package uz.akbar;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import uz.akbar.util.ConnectionUtil;

/**
 * TableRepository
 */
public class TableRepository {

	public void createTables() {
		String sql = "create table if not exists profile(" +
				"id serial primary key," +
				"name varchar(25) not null," +
				"surname varchar(25) not null," +
				"login varchar(25) not null unique," +
				"password varchar(45) not null," +
				"phone varchar(12) not null," +
				"status varchar(15) not null," +
				"role varchar(15) not null," +
				"created_date timestamp default now()" +
				")";

		Connection connection = ConnectionUtil.getConnection();
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
