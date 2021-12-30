package Entities;

public class Competency extends AbstractEntity {

	public int teacherId;
	public String name;
	
	public Competency(int id, int teacherId, String name) {
		super(id);
		this.teacherId = teacherId;
		this.name = name;
	}
	
	

}
