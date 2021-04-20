package workspace.store;

import workspace.bean.Student;
import workspace.bean.Teacher;

import java.io.Serializable;

//Studentleri qeydiyyata alib burada saxlayiriq,bura yaziriq
//buradan oxuyuruq

public class AppStorage implements Serializable {
    public Student[] students = new Student[100];
    public int currentStudentIndex = 0;
    public Teacher[] teachers = new Teacher[100];
    public int currentTeacherIndex = 0;

    //bazaya tekce appstoragi yaziram onu oxuyuram

}
