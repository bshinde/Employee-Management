package employeeManagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employeeManagement.model.employee;

public class employeedao {
		
		private static String jdbcURL = "jdbc:mysql://localhost:3306/employee?useSSL=false";
		private static String jdbcUsername = "root";
		private static String jdbcPassword = "root123";

		private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + "  (Name, Address, Gender, Salary, BirthDate ) VALUES "
				+ " (?, ?, ?, ?, ?);";
		private static final String SELECT_EMPLOYEE_BY_ID = "select employeeId, Name, Address, Gender, Salary, BirthDate from employee where employeeId =?;";
		private static final String SELECT_ALL_EMPLOYEE = "Select * from employee;";
		private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employeeId = ?;";
		private static final String UPDATE_EMPLOYEE_SQL = "update employee set Name = ?,Address= ?, Gender =?, Salary=?, birthDate=?  where employeeId = ?;";

		protected static Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}

		public void insertEmployee(employee employee) throws SQLException {
			System.out.println(INSERT_EMPLOYEE_SQL);
			// try-with-resource statement will auto close the connection.
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setString(2, employee.getAddress());
				preparedStatement.setString(3, employee.getGender());
				preparedStatement.setInt(4, employee.getSalary());
				preparedStatement.setString(5, employee.getBirthDate());

				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
      
		public employee selectEmployee(int id) {
			employee employee = null;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String Name = rs.getString("Name");
					String Address = rs.getString("Address");
					String Gender = rs.getString("Gender");
					int Salary = rs.getInt("Salary");
					String BirthDate = rs.getString("BirthDate");

					employee = new employee( id, Name, Address, Gender, Salary, BirthDate);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return employee;
		}

		public List<employee> selectAllEmployee() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			List<employee> employees = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int employeeId = rs.getInt("employeeId");
					String Name = rs.getString("Name"); 
					String Address = rs.getString("Address");
					String Gender = rs.getString("Gender");
					int Salary = rs.getInt("Salary");
					String Birthdate = rs.getString("BirthDate");


					employees.add(new employee(employeeId, Name, Address, Gender, Salary, Birthdate ));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return 	employees;
		}

   
		
		
		

		public boolean deleteEmployee(int employeeId) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
				statement.setInt(1, employeeId);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}

		public boolean updateEmployee(employee employee) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
				statement.setString(1, employee.getName());
				statement.setString(2, employee.getAddress());
				statement.setString(3, employee.getGender());
				statement.setInt(4, employee.getSalary());
				statement.setString(5, employee.getBirthDate());
				statement.setInt(6, employee.getEmployeeId());

				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}

		private static void printSQLException(SQLException ex) {
			for (Throwable e : ex) {
				if (e instanceof SQLException) {
					e.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}

	}