package AppStart;

public class DatabaseCreator {

	public static void Seed() {
		String account = "insert into account values (1, \"szymon\", \"haslo\");";
		String pd = "insert into personaldata values (1, \"szymon\", \"kubiak\", \"123\", \"kaliska\", \"997\",1);";
		String st = "insert into student values (1,1);";
		
		DatabaseConnector.executeUpdate(account);
		DatabaseConnector.executeUpdate(pd);
		DatabaseConnector.executeUpdate(st);
	}
}
