package main.java;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    
    private Student student;
    private Course course;
    private double grade;
    private List<Student> regList = new ArrayList<>();
    
    
    public Registration() {
        //ctor
    }
    
    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
        setGrade(0);
        regList.add(this.student);
    }
    
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    public double getGrade() {
        return grade; 
    }
    
    public Student getStudent(String name) {
        
        for (int i = 0; i < regList.size(); i++) {
            if(regList.get(i).getAsurite().equals(name)) {
                return regList.get(i);
            } else {
                System.out.println("Student not found.");
            }
        }
        return null;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public List<Registration> getRegList() {
        return regList;
    }
    
    public void setRegList(List<Registration> regList) {
        this.regList = regList;
    }
    
    public Registration newRegister(String name, Course couse) {
        
        if (regList.size() == 0) {
            Student student = new Student(name, null);
            return new Registration(student, course);
        }
        for (int i = 0; i < regList.size(); i++) {
            if(regList.get(i).getStudent().getAsurite().equals(name)) {
                System.out.println("Student already registered for course.");
            } else {
                Student student = new Student(name, null);
                return new Registration(student, course);
            }
        }
        return null;
        
    }
    
      
    

}
