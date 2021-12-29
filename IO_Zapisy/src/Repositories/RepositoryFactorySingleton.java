package Repositories;

public class RepositoryFactorySingleton {
	private static RepositoryFactory rf;
	
	public static RepositoryFactory getInstance() {
		if(rf == null) {
			rf = new RepositoryFactory();
		}
		return rf;
	}
}
