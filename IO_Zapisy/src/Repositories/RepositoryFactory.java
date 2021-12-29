package Repositories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import Entities.AbstractEntity;


public class RepositoryFactory {
	
	List<GenericRepository<AbstractEntity>> repositories;
	static RepositoryFactory rf;

	public <Repository extends GenericRepository> Repository getRepository(Class<Repository> repositoryClass) {
		
		String repositoryName = repositoryClass.getName();
		int index = -1;
		for(int i = 0; i < RepositoryDictionary.dictionary.size(); i++) {
			if (RepositoryDictionary.dictionary.get(i).repositoryName.equals(repositoryName)) {
				index = i;
				break;
			}
		}
		
		return (Repository)repositories.get(index);
	}
	
	
	 RepositoryFactory() {
		
		repositories = new LinkedList<GenericRepository<AbstractEntity>>();
		
		RepositoryDictionary.dictionary.forEach(dictionaryRecord -> {
			try {
				Class repositoryClass = Class.forName(dictionaryRecord.repositoryName);
				Constructor<GenericRepository<AbstractEntity>> ctor = repositoryClass.getConstructor();
				GenericRepository<AbstractEntity> repo = ctor.newInstance(null);
				repo.createTable();
				repositories.add(repo);
				
			} 
			catch (ClassNotFoundException e) {

			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
