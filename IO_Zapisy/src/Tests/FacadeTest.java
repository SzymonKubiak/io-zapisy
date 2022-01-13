package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;

import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import Entities.*;
import Entities.PersonalData;
import Enums.RoomDestination;
import Facades.Facade;
import Factories.PersonFactory;
import Repositories.ClassroomRepository;
import Repositories.CourseRepository;
import Repositories.GroupRepository;
import Repositories.RepositoryFactory;
import Repositories.RepositoryFactorySingleton;

@Category(TestFacade.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class FacadeTest {

	static TestData testData;
	private Facade facade = new Facade();
	PersonFactory p = new PersonFactory();
	RepositoryFactory repoFactory = RepositoryFactorySingleton.getInstance();

	@BeforeAll
	public static void initData() {
		testData = new TestData();
	}

	@Test
	void testEnrollStudentToGroup() {
		// Create Student
		int dataIndex = 0;
		PersonalData student = p.createStudent(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], 1,
				"informatyka");
		Group group = this.createGroup();
		
		Enrollment enrollment = facade.enrollStudentToGroup(student.id, group.id);
		assertNotNull(enrollment);
		
		dataIndex = 5;
		PersonalData student2 = p.createStudent(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], 1,
				"informatyka");
		
		Enrollment enrollment2 = facade.enrollStudentToGroup(student.id, group.id);
		assertNull(enrollment2, "Classroom capacity reached");
	}

	@Test
	void testEditPersonalData() {
		//Create student and edit data
		int dataIndex = 0;
		PersonalData student = p.createStudent(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], testData.year[dataIndex],
				testData.subject[dataIndex]);
		
		student.PESEL = testData.pesel[dataIndex + 1];
		
		PersonalData student2 = facade.editPersonalData(student);
		
		assertEquals(student2.PESEL, student.PESEL);
		assertEquals(student2.phoneNumber, student.phoneNumber);
		
		TestData.cleanTablesAfterTest();
	}
	
	Group createGroup() {
		ClassroomRepository classroomRepo = repoFactory.getRepository(ClassroomRepository.class);
		CourseRepository courseRepo = repoFactory.getRepository(CourseRepository.class);
		GroupRepository groupRepo = repoFactory.getRepository(GroupRepository.class);
		
		Classroom classroom = new Classroom(0, RoomDestination.Laboratory,"C-13", "103L", 2);
		classroom = classroomRepo.create(classroom);
		Course course = new Course(0, RoomDestination.Laboratory, "AK2", "Architektura procesora", 1, "informatyka");
		course = courseRepo.create(course);
		
		int dataIndex = 1;
		PersonalData teacher = p.createTeacher(testData.login[dataIndex], testData.password[dataIndex],
				testData.name[dataIndex], testData.surname[dataIndex], testData.pesel[dataIndex],
				testData.phone[dataIndex], testData.address[dataIndex], null);


		Group group = new Group(0, teacher,new Time(13,0,0), 1, course, classroom);
		group = groupRepo.create(group);
		return group;
	}

}
