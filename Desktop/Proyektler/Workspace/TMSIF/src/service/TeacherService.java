package service;

import main.FileReadAndWrite;
import main.Main;
import workspace.bean.Student;
import workspace.bean.Teacher;

import java.util.Scanner;

import static util.inputUtil.*;

public class TeacherService {
    public static void showMenu() {
        while (true) {
            System.out.println("Please choose action from menu:\n" +
                    "1. register teacher\n" +
                    "2. delete teacher\n" +
                    "3. find teacher\n" +
                    "4. show all teachers\n" +
                    "5. assign  student\n" +
                    "6. exit\n" +
                    "7. main menu\n");
            Integer menuId = new Scanner(System.in).nextInt();
            if (menuId == 1) {
                registerTeacher();

            } else if (menuId == 2) {
                deleteTeacher();

            } else if (menuId == 3) {
                findTeacher();

            } else if (menuId == 4) {
                showAllTeachers();

            } else if (menuId == 5) {
                assignStudentToTeacher();
            } else if (menuId == 6) {
                System.out.println("App exited");
                return;
            } else if (menuId == 7) {
                Main.showMainMenu();
            } else System.out.println("Please choose again");
            FileReadAndWrite.writeObject(Main.appStorage);

        }
    }
    public static void registerTeacher() {
        Teacher teacher = new Teacher(Main.appStorage.currentTeacherIndex + 1,
                requireString("enter name"),
                requireString("enter surname"),
                requireDouble("enter salary"));
        Main.appStorage.teachers[Main.appStorage.currentTeacherIndex++] = teacher;
        System.out.println("teacher successfully registered" + teacher);
    }

    public static void deleteTeacher() {
        showAllTeachers();
        int id = requireInt("type teacher id to delete:");
        for (int i = 0; i < Main.appStorage.teachers.length; i++) {
            if ((Main.appStorage.teachers[i] != null && (id == Main.appStorage.teachers[i].getId()))) {
                System.out.println(Main.appStorage.teachers[i] + "succesfully deleted");
                Main.appStorage. teachers[i] = null;
                break;
            }
        }
        showAllTeachers();
    }


    public static void findTeacher() {
        String findKey = requireString("type name, surname, scholarship or id");

        for (int i = 0; i < Main.appStorage.teachers.length; i++) {
            if (Main.appStorage.teachers[i] != null &&Main.appStorage. teachers[i].toString().contains(findKey)) {
                System.out.println("found" +Main.appStorage. teachers[i]);

            }
        }
    }

    public static Teacher findTeacherById(int id) {
        for (int i = 0; i <Main.appStorage. teachers.length; i++) {
            if (Main.appStorage.teachers[i] != null && Main.appStorage.teachers[i].getId() == id) {
                return Main.appStorage.teachers[i];
            }
        }
        return null;
    }

    public static void showAllTeachers() {
        System.out.println("All teachers:");
        {
            for (int i = 0; i < Main.appStorage.teachers.length; i++) {
                if (Main.appStorage.teachers[i] != null) {
                    System.out.println(Main.appStorage.teachers[i].toString());
                }
            }
        }
    }

    public static void assignStudentToTeacher() {

        showAllTeachers();
        Teacher selectedTeacher = findTeacherById(requireInt("which teacher you want to assign new student"));

        StudentService.showAllStudents();
        Student selectedStudent = StudentService.findStudentById(requireInt("which student you want to assign?"));

        if (selectedTeacher.findStudentById(selectedStudent.getId()) == null)
            selectedTeacher.getStudents()[selectedTeacher.lastStudentIndex++] = selectedStudent;
        else System.out.println("already assigned");

    }
}