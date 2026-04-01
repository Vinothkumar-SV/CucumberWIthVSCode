package dbTestOrangeHRM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnection {

	public String Database(String employeeId) throws Exception {

		employeeId = OrangeHRMTest.EmpId;
		String url = "jdbc:mysql://localhost:3306/orangehrm";
		String username = "root";
		String password = ""; // put your MySQL password if you set one

        String sql = "SELECT employee_id FROM hs_hr_employee WHERE employee_id = '" + employeeId + "'";

		Connection con = DriverManager.getConnection(url, username, password);

		Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        String dbEmployeeId = "";

        if (rs.next()) {
            dbEmployeeId = rs.getString("employee_id");
            System.out.println("Employee ID from DB: " + dbEmployeeId);
        }

        rs.close();
        stmt.close();
        con.close();

        return dbEmployeeId;
	}
}