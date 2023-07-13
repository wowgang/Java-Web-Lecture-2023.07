package ch99;

public class Main {

	public static void main(String[] args) {
		dbWork(new MySqlDaoImpl());
		dbWork(new OracleDaoImpl());
	}

	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}


}
