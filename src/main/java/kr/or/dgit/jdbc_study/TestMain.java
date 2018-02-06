package kr.or.dgit.jdbc_study;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Map.Entry;

import kr.or.dgit.db_connection.jdbc.DBConn;
import kr.or.dgit.db_connection.jdbc.LoadProperties;

public class TestMain {
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		testDBConnection();
	}

	private static void testDBConnection() throws SQLException, FileNotFoundException {
		DBConn dbConn = DBConn.getInstance();
		System.out.println(dbConn);
		
		Properties prop = LoadProperties.getInstance().getProperties();
		
		for (Entry<Object, Object> e : prop.entrySet()) {
			System.out.printf("%s : %s%n", e.getKey(), e.getValue());
		}
	}
}
