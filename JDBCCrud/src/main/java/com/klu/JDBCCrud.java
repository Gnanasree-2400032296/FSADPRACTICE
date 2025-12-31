package com.klu;
import java.sql.*;

public class JDBCCrud {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/fsads3";
		String usr="root";
		String pwd="Gnanasree@16";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,usr,pwd);
		System.out.println("Connection established");
		Statement st=con.createStatement();
		String createDept=
				createDept =
                "CREATE TABLE IF NOT EXISTS Dept (" +
                "dept_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "dept_name VARCHAR(20))";
		st.execute(createDept);
		System.out.println("Department table created");
		
		String createEmp =
                "CREATE TABLE IF NOT EXISTS Emp (" +
                "emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "emp_name VARCHAR(50), " +
                "sal DOUBLE, " +
                "dept_id INT, " +
                "FOREIGN KEY (dept_id) REFERENCES Dept(dept_id))";
		st.execute(createEmp);
		System.out.println("Employee table created");
		
		  String insertDept1 = "INSERT INTO Dept (dept_name) VALUES ('HR')";
          String insertDept2 = "INSERT INTO Dept (dept_name) VALUES ('IT')";
          String insertDept3 = "INSERT INTO Dept (dept_name) VALUES ('Finance')";

          st.executeUpdate(insertDept1);
          st.executeUpdate(insertDept2);
          st.executeUpdate(insertDept3);
          System.out.println("Departments inserted");

          // Insert values into Emp table
          String insertEmp1 =
                  "INSERT INTO Emp (emp_name, sal, dept_id) VALUES ('Ravi', 30000, 1)";
          String insertEmp2 =
                  "INSERT INTO Emp (emp_name, sal, dept_id) VALUES ('Sita', 45000, 2)";
          String insertEmp3 =
                  "INSERT INTO Emp (emp_name, sal, dept_id) VALUES ('Kiran', 40000, 3)";

          st.executeUpdate(insertEmp1);
          st.executeUpdate(insertEmp2);
          st.executeUpdate(insertEmp3);
          System.out.println("Employees inserted");

          con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}