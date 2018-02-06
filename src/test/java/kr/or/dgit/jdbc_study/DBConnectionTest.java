package kr.or.dgit.jdbc_study;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.db_connection.jdbc.DBConn;

public class DBConnectionTest {
	private static DBConn dbConn;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbConn = DBConn.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dbConn.connectionClose();
	}

	@Test
	public void test() {
		Connection conn = dbConn.getConnection();
		assertNotNull(conn);
	}

}
