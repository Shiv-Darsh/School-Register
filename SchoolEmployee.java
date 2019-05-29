package com.company;

import java.sql.*;
import java.util.Scanner;

class SchoolEmployee {
    private String work, employeeName, address;
    private int employeeNo;

    private Scanner scn = new Scanner(System.in);


    public void addEmployee() {
        System.out.println("Enter new employee name: ");
        this.employeeName = scn.nextLine();
        System.out.println("Enter new employee contact number:");
        this.employeeNo = scn.nextInt();
        scn.nextLine();
        System.out.println("Enter work assigned to new employee:");
        this.work = scn.nextLine();
        System.out.println("Enter address of new employee:");
        this.address = scn.nextLine();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\SOFT\\SQLite databases\\School Register\\EmployeeDatabase.db");
             Statement statement = conn.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Employee( Employee_Name text, Contact_Number " +
                    "integer, Work text, Address varchar)");

            statement.execute("INSERT INTO Employee(Employee_Name, Contact_Number,  Work, Address) VALUES(" +
                    "'" + employeeName + "', " + employeeNo + ", '" + work + "', '" + address + "' )");
        } catch (SQLException e) {
            System.out.println("something went wrong : " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void showAllEmployees() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\SOFT\\SQLite databases\\School Register\\EmployeeDatabase.db");
             Statement statement = conn.createStatement()) {

            ResultSet results = statement.executeQuery("SELECT * FROM Employee");
            ResultSetMetaData meta = results.getMetaData();
            int numcolumns = meta.getColumnCount();
            for (int i = 1; i <= numcolumns; i++) {
                System.out.print(meta.getColumnName(i) + "      ");
            }
            System.out.println();
            while (results.next()) {
                System.out.println(results.getString("Employee_Name") + " || " + results.getInt("Contact_Number") + " || " +
                        results.getString("Work") + " || " + results.getString("Address"));
            }

        } catch (SQLException e) {
            System.out.println("something went wrong : " + e.getMessage());
            e.printStackTrace();
        }

    }

}