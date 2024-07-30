package uz.akbar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import uz.akbar.enums.ProfileRole;
import uz.akbar.enums.ProfileStatus;

/**
 * ProfileRepository
 */
public class ProfileRepository {

	public Profile getByLogin(String login) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select id, name, surname, login, password, phone, status, role, created_date from profile where login=?");
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return new Profile(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("surname"),
						resultSet.getString("login"),
						resultSet.getString("password"),
						resultSet.getString("phone"),
						ProfileStatus.valueOf(resultSet.getString("status")),
						ProfileRole.valueOf(resultSet.getString("role")),
						resultSet.getTimestamp("created_date").toLocalDateTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int create(Profile profile) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into profile(name, surname, login, password, phone, status, role, created_date) values(?, ?, ?, ?, ?, ?, ?, ?);");

			preparedStatement.setString(1, profile.getName());
			preparedStatement.setString(2, profile.getSurname());
			preparedStatement.setString(3, profile.getLogin());
			preparedStatement.setString(4, profile.getPassword());
			preparedStatement.setString(5, profile.getPhone());
			preparedStatement.setString(6, profile.getStatus().name());
			preparedStatement.setString(7, profile.getRole().name());
			preparedStatement.setTimestamp(8, Timestamp.valueOf(profile.getCreatedDate()));

			int effectedRow = preparedStatement.executeUpdate();
			return effectedRow;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
