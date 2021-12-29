package Repositories;

import java.util.Arrays;
import java.util.List;

public class RepositoryDictionary {
	
	static List<DictionaryRecord> dictionary = Arrays.asList(
			new DictionaryRecord("Account"),
			new DictionaryRecord("Classroom"),
			new DictionaryRecord("Competency"),
			new DictionaryRecord("Course"),
			new DictionaryRecord("Enrollment"),
			new DictionaryRecord("Group"),
			new DictionaryRecord("PersonalData"),
			new DictionaryRecord("Student"),
			new DictionaryRecord("Teacher")
			);
	
}

class DictionaryRecord {
	
	String entityName;
	String repositoryName;
	
	DictionaryRecord(String entityName) {
		this.entityName = "Entities." + entityName;
		this.repositoryName =  "Repositories." + entityName + "Repository";
	}
}