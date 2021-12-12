package Repositories;

import java.util.Arrays;
import java.util.List;

public class RepositoryDictionary {
	
	static List<DictionaryRecord> dictionary = Arrays.asList(
			new DictionaryRecord("Account")
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