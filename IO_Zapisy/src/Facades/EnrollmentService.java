package Facades;

import Repositories.EnrollmentRepository;
import Repositories.GroupRepository;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;

import java.util.List;

import Entities.*;

public class EnrollmentService {

	RepositoryFactory repositoryFactory;
	EnrollmentRepository enrollmentRepo;
	GroupRepository groupRepo;

	public EnrollmentService() {
		this.repositoryFactory = RepositoryFactorySingleton.getInstance();
		this.enrollmentRepo = repositoryFactory.getRepository(EnrollmentRepository.class);
		this.groupRepo = repositoryFactory.getRepository(GroupRepository.class);
	}

	public boolean doesStudentHaveRightsToGroup(PersonalData student, Group group) {
		// another year or subject of study
		if (student.yearOfStudy != group.course.yearOfStudy
				|| !student.educationSubject.equals(group.course.educationSubject))
			return false;

		// student already enrolled to group of that course
		List<Enrollment> studentEnrollments = getStudentEnrollments(student);
		final String courseTitle = group.course.title;
		boolean alreadyEnrolledToCourse = studentEnrollments.stream()
				.anyMatch(en -> en.group.course.title.equals(courseTitle));
		if (alreadyEnrolledToCourse)
			return false;

		// no empty space in classroom
		List<PersonalData> enrolledStudents = this.getGroupMembers(group);
		if (enrolledStudents.size() >= group.classroom.capacity)
			return false;

		else
			return true;
	}

	private List<Enrollment> getStudentEnrollments(PersonalData student) {

		List<Enrollment> enrollmentList = enrollmentRepo.getAll();
		final int fStudentId = student.id;
		List<Enrollment> studentEnrollments = enrollmentList.stream().filter(en -> en.student.id == fStudentId)
				.toList();
		return studentEnrollments;
	}

	private List<PersonalData> getGroupMembers(Group group) {

		List<Enrollment> enrollmentList = enrollmentRepo.getAll();
		final int fGroupId = group.id;
		List<PersonalData> groupMembers = enrollmentList.stream().filter(en -> en.group.id == fGroupId)
				.map(en -> en.student).toList();
		return groupMembers;
	}
}
