package utils;

import java.sql.Connection;

public class DbConnection {

	static Connection conn;

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		DbConnection.conn = conn;
	}
}
