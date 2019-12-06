package main.java;

import java.util.ArrayList;
import java.util.List;



public class Student {
    private String asurite;
    private Major major;
    private double overallGrade;
    private List<Course> courses = new ArrayList<Course>();
    private Registration reg;
    
    /**Ctor for Student:  set asurite, major and overall grade.
     * @param asurite student id
     * @major student chose major */
    public Student(String asurite, Major major) {
        this.setAsurite(asurite);
        this.setMajor(major);
        setOverall_grade(0);

    }

    public String getAsurite() {
        return asurite;
    }

    public void setAsurite(String asurite) {
        this.asurite = asurite;
    }

    public Major getMajor() {
        return major;
    }

    public boolean register_forCourse(Course course) {
        course.addStudent(this);
        return courses.add(course);
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public double getOverall_grade() {
        return overallGrade;
    }

    public void setOverall_grade(double overallGrade) {
        this.overallGrade = overallGrade;
    }
    
    //SER316TASK2SPOTBUGS FIX
    @Override
    public int hashCode() {
        assert false : "hashCode not designed";
        return 42;
    }

    /**equals method to compare attributes.
     * @param other Object to compare to null, this, class, and student asurite id.
     * @return false if null, classes are not equal.
     * @else true if this object matches passed object and matching asurite ids. */
    @Override
    public boolean equals(Object other) {
        
        if (other == null) {
            return false;
        }
        
        if (checkFault(other)) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Student s = (Student) other;
        return this.getAsurite().equals(s.getAsurite());
    }
    
    
    /**Helper method for equals(Object Other. */
    private boolean checkFault(Object other) {
        
        if (other == this) {
            return true;
        } else if (other.hashCode() == 42) {  //SER316TASK2SPOTBUGS FIX
            return false;
        }
        
        return false;
    }
    
    
    

}
