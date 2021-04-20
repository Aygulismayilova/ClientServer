package service;

import main.FileReadAndWrite;
import main.Main;
import workspace.bean.Student;

import java.util.Scanner;

import static util.inputUtil.*;

public class StudentService {
    public static void showMenu() {
        while (true) {
            System.out.println("Please choose action from menu:\n" +
                    "1. register student\n" +
                    "2. delete student\n" +
                    "3. find student\n" +
                    "4. show all students\n" +
                    "5. exit\n" +
                    "6. main menu\n");
            Integer menuId = new Scanner(System.in).nextInt();
            if (menuId == 1) {
                registerStudent();
            } else if (menuId == 2) {
                deleteStudent();
            } else if (menuId == 3) {
                findStudent();
            } else if (menuId == 4) {
                showAllStudents();
            } else if (menuId == 5) {
                //System.exit(1);
                // break;
                System.out.println("App exited");
                return;
            }else if (menuId==6){
                Main.showMainMenu();

            }
            else {
                System.out.println("MenuId is wrong.Please choose again.");
            }
            FileReadAndWrite.writeObject(Main.appStorage);
        }
    }
    public static Student registerStudent() {
        Student student = new Student(Main.appStorage.currentStudentIndex + 1,
                requireString("enter name:"),
                requireString("enter surname:"),
                requireDouble("enter scholarship"));
        Main.appStorage.students[Main.appStorage.currentStudentIndex++] = student;
        System.out.println("student successfully registered:" + student);
        return student;
    }

    public static void deleteStudent() {
        showAllStudents();
        int id = requireInt("type student id to delete");
        for (int i = 0; i < Main.appStorage.students.length; i++) {
            if (Main.appStorage.students[i] != null && Main.appStorage.students[i].getId() == id) {//Main.Main.appStorage.students[i].getId().intValue == id.intValue
                System.out.println("successfully deleted");
                Main.appStorage.students[i] = null;
                break;

            }
        }
        showAllStudents();
    }

    public static void findStudent() {
        String findKey = requireString("type name, surname, scholarship or id");
        for (int i = 0; i < Main.appStorage.students.length; i++) {
            if ((Main.appStorage.students[i] != null) && (Main.appStorage.students[i].toString().contains(findKey))) {
                System.out.println("found:" + Main.appStorage.students[i]);

            }
        }
    }

    public static Student findStudentById(int id) {
        for (int i = 0; i < Main.appStorage.students.length; i++) {
            if ((Main.appStorage.students[i] != null) && (Main.appStorage.students[i].getId() == id)) {
                return Main.appStorage.students[i];
            }
        }
        return null;
    }

    public static void showAllStudents() {
        System.out.println("all students");
        for (int i = 0; i < Main.appStorage.students.length; i++) {
            if (Main.appStorage.students[i] != null)
                System.out.println(Main.appStorage.students[i]);
        }
    }


}
