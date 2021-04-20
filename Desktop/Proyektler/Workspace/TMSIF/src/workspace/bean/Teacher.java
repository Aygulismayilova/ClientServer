package workspace.bean;

import java.io.Serializable;

public class Teacher implements Serializable {

    //register studentin return etdiyi studenti buradaki students massivine otuzdurmaq
//
    private Integer id;
    private String name;
    private String surname;
    private Double salary;
    private Student[] students = new Student[100];
    public int lastStudentIndex = 0;

    public Teacher(Integer id, String name, String surname, Double salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Student[] getStudents() {

        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }


    public String toString() {
        return " " + id +
                ", " + name +
                ", " + surname +
                ", " + salary + ", " + printStudents();
    }

    public Student findStudentById(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    public String printStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) stringBuilder.append(students[i] + ";");
        }
        return stringBuilder.toString();
    }

}
