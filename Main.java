package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("****** WELCOME TO SCHOOL REGISTER SYSTEM ( MINOR JAVA PROJECT ) ******");
        System.out.println("***************** DEVELOPED BY ABHISHEK SINGH VERMA *****************");
        System.out.println("\n\nPress any key to continue...");


        scan.next();

        Class clas = new Class();
        SchoolEmployee emp = new SchoolEmployee();

        System.out.println("\n");
        int choice;

        do {
            System.out.println("\n");
            System.out.println("\n What action do you want to perform:\n" + "1. Add new student \n" +
                    "2. Show existing students\n" + "3. Add new employee (Teacher, Staff, etc.)\n" +
                    "4. Show existing employee\n" + "5. Press 5 to exit");
            choice = scan.nextInt();
            System.out.println("\n");

            switch (choice) {
                case 1: {
                    // System.out.println(object.getClass().getSimpleName());
                    System.out.println("1. Add new student in new class \n2. Add new student in existing class\n"
                            + "3. Press any number to exit");
                    int x = scan.nextInt();

                    if (x == 1) {
                        clas.addClass();
                        clas.addStudentInClass();
                    } else if (x == 2) {
                        clas.showClass();
                        clas.addStudentInClass();
                    } else {
                        System.exit(0);
                    }
                    break;
                }
                case 2: {
                    clas.showClass();
                    System.out.println("Enter class in which you want to see students");
                    String cl = scan.next();
                    clas.showAllStudents(cl);
                    break;
                }

                case 3: {
                    emp.addEmployee();
                    break;
                }

                case 4: {
                    emp.showAllEmployees();
                    break;
                }

                case 5: {
                    System.exit(0);
                }

            }

        } while (choice != 5);
    }
}
