package main;

import service.StudentService;
import service.TeacherService;
import workspace.store.AppStorage;

import java.util.Scanner;

public class Main {
    public static AppStorage appStorage = new AppStorage();

    public static void main(String[] args) {
        appStorage =  FileReadAndWrite.readObject();

        //burada appstoragei fayldan oxu

        // write your code here
        //kodu yazmaga basladi
        //1.02ci deqiqede qaldim
        //Muellimde cetinlik bir muellimi yaradanda ona student de yarada bilmeliyik
        //menulardan birinde bele bir sey olacaq bu muellim ucun telebe yarat
        //telebeni yaradib muellimin telebeler obyektine yeni arrayine hemin telebeni set
        //etmeliyik
        //muellimi yaradanda adi soyadi maasini teleb edeceyik
        //eyni prinsipde sora student set eleyeceyik

        showMainMenu();
    }

    public static void showMainMenu() {
        while (true) {
            System.out.println("teacher or student");
            String menuType = new Scanner(System.in).nextLine();
            if ("student".equalsIgnoreCase(menuType)) {
                StudentService.showMenu();
            } else if ("teacher".equalsIgnoreCase(menuType)) {
                TeacherService.showMenu();
            }

        }//appstoragei fayla yaza
    }


}