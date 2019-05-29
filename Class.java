package com.company;


import java.sql.*;
import java.util.Scanner;

class Class extends Student {
    private Scanner s = new Scanner(System.in);

    public void addClass() {
        System.out.println("Enter new class name: ");
        String newClassName = s.nextLine();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\SOFT\\SQLite databases\\School Register\\StudentDatabase.db");
             Statement statement = conn.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS " + newClassName + "( Student_Name text, Father_Name " +
                    "text, Student_Phone integer, Father_Phone integer, Address varchar)");
        } catch (SQLException e) {
            System.out.println("something went wrong : " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void showClass() {

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\SOFT\\SQLite databases\\School Register\\StudentDatabase.db");
        ) {

            DatabaseMetaData dbmd = conn.getMetaData();
            String table[] = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, null, table);

            while (rs.next()) {
                System.out.println(rs.getString(3));
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("something went wrong : " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void addStudentInClass() {
        System.out.println("Enter class name in which you want to add new student : ");
        String className = s.nextLine();
        addStudent();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\SOFT\\SQLite databases\\School Register\\StudentDatabase.db");
             Statement statement = conn.createStatement()) {
            statement.execute("INSERT INTO " + className + "(Student_name, Father_Name, Student_phone, " +
                    "Father_Phone, Address) VALUES('" + studentName + "', '" + fatherName + "', " + studentNo +
                    ", " + fatherNo + ", '" + address + "')");
        } catch (SQLException e) {
            System.out.println("something went wrong : " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void showAllStudents(String cla) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\SOFT\\SQLite databases\\School Register\\\\StudentDatabase.db");
             Statement statement = conn.createStatement()) {

            ResultSet results = statement.executeQuery("SELECT * FROM " + cla);
            ResultSetMetaData meta = results.getMetaData();
            int numcolumns = meta.getColumnCount();
            for (int i = 1; i <= numcolumns; i++) {
                System.out.print(meta.getColumnName(i) + "      ");
            }
            System.out.println();
            while (results.next()) {
                System.out.println(results.getString("Student_Name") + " || " + results.getString("Father_Name") +
                        " || " + results.getInt("Student_Phone") + " || " + results.getInt("Father_Phone") +
                        " || " + results.getString("Address"));
            }

        } catch (SQLException e) {
            System.out.println("something went wrong : " + e.getMessage());
            e.printStackTrace();
        }

    }
}