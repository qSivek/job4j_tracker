package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Golovach Lena Vladimirovna");
        student.setGroup("PU20");
        student.setReceiptDate("14.07.22");
        System.out.println("Student " + student.getFullName() + " who studies in the " + student.getGroup()
                + " group has enrolled " + student.getReceiptDate());
    }
}
