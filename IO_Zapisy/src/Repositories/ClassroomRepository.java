package Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import AppStart.DatabaseConnector;
import Entities.AbstractEntity;
import Entities.Account;
import Entities.Classroom;
import Enums.RoomDestination;

public class ClassroomRepository extends GenericRepository<Classroom> {

	public ClassroomRepository() {
		super("Classroom");
	}

	@Override
	protected Classroom resultToObject(ResultSet rs) {
		Classroom cl = null;
		try {
			//if(!rs.next()) return null;
			int id = rs.getInt("id");
			int destination = rs.getInt("destination");
			String building = rs.getString("building");
			String roomId = rs.getString("roomId");
			int capacity = rs.getInt("capacity");
			cl = new Classroom(id, RoomDestination.toEnum(destination), building, roomId, capacity);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl;
	}


	@Override
	protected void createTable() {
		DatabaseConnector.executeUpdate("DROP TABLE IF EXISTS  Classroom;");
		StringBuilder sb = new StringBuilder()
	            .append("CREATE TABLE IF NOT EXISTS Classroom (")
	            .append("id int AUTO_INCREMENT PRIMARY KEY,")
	            .append("destination int,")
	            .append("building varchar(50),")
	            .append("capacity int,")
	            .append("roomId varchar(50)")
	            .append(");");

		String query = sb.toString();	
		DatabaseConnector.executeUpdate(query);

	}

	@Override
	protected String objectToInsertQuery(Classroom e) {
		StringBuilder sb = new StringBuilder()
	            .append("INSERT INTO Classroom (destination, building, roomId, capacity) VALUES (")
	            .append("\"" + e.destination.ordinal() + "\", ")
	            .append("\"" + e.building + "\", ")
	            .append("\"" + e.roomId + "\", ")
	            .append("\"" + e.capacity+ "\"")
	            
	            .append(");");

		return sb.toString();	
	}

	@Override
	protected String objectToUpdateQuery(Classroom e) {
		StringBuilder sb = new StringBuilder()
	            .append("UPDATE Classroom SET ")
	            .append("destination = \""+ e.destination.ordinal() + "\", ")
	            .append("building = \""+e.building + "\", ")
	            .append("roomId = \""+e.roomId+ "\", ")
	            .append("capacity = \""+e.capacity+ "\"")
	            .append("WHERE id = "+ e.id)
	            .append(";");

		return sb.toString();	
	}

}
