package Repositories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import Entities.AbstractEntity;

public class RepositoryFactory {
	
	List<GenericRepository<AbstractEntity>> repositories;

	public <Repository extends GenericRepository<AbstractEntity>, Entity> Repository getRepository(Class<Repository> repositoryClass) {
		
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
	
	
	public RepositoryFactory() {
		
		this.repositories = new LinkedList<GenericRepository<AbstractEntity>>();
		
		RepositoryDictionary.dictionary.forEach(dictionaryRecord -> {
			try {
				Class repositoryClass = Class.forName(dictionaryRecord.repositoryName);
				Constructor<GenericRepository<AbstractEntity>> ctor = repositoryClass.getConstructor();
				repositories.add((GenericRepository<AbstractEntity>)ctor.newInstance(null));
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
