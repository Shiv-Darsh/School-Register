package com.company;

import java.util.Scanner;

class Student {
    private Scanner sc = new Scanner(System.in);
    String studentName, fatherName, address;
    int studentNo, fatherNo;

    public void addStudent() {
        sc.nextLine();
        System.out.println("\n Enter student name: ");
        this.studentName = sc.nextLine();
        System.out.println(" Enter father name: ");
        this.fatherName = sc.nextLine();
        System.out.println(" Enter address: ");
        this.address = sc.nextLine();
        System.out.println(" Enter student phone number: ");
        this.studentNo = sc.nextInt();
        System.out.println(" Enter father phone number: ");
        this.fatherNo = sc.nextInt();
    }

}
