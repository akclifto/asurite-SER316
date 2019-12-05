package main.java;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, Student> students = new HashMap<>();
    //change to one that works with happy day case
    static Map<String, CourseGrades0> courses = new HashMap<>();
    //change to one that works with happy day case
    static Map<String, CourseGrades4> courses4 = new HashMap<>(); 

    /**JavaDoc Comments for main method.  sets up students and courses 
     * to curve.
     *  */
    public static void main(String[] args) throws Exception {

        setStudents();
        setCourses();
        getCourses();

        courses.get("SER315").countOccurencesLetterGrades(true);

        System.out.println("CURVE:\n" 
                + "     * >  89% -> A\n"
                + "     * >  79% -> B\n"
                + "     * >  59% -> C\n"
                + "     * >  35% -> D\n"
                + "     * <= 35% -> F");
        courses4.get("SER315").curveLetterGrades();

    }
    
    /**Helper method to set set students for main. */
    public static void setStudents() {
        
        students.put("anna", new Student("anna", Major.valueOf("SER")));
        students.put("karl", new Student("karl", Major.valueOf("CS")));
        students.put("franz", new Student("franz", Major.valueOf("CS")));
        students.put("harry", new Student("harry", Major.valueOf("SER")));
        students.put("aneesh", new Student("aneesh", Major.valueOf("SER")));
        students.put("rebecca", new Student("rebecca", Major.valueOf("SER")));
        students.put("alex", new Student("alex", Major.valueOf("SER")));
        students.put("rose", new Student("rose", Major.valueOf("SER")));
    }
    
    /**Helper method to set courses for main. */
    public static void setCourses() {
        
        courses.put("SER316", new CourseGrades0("SER316"));
        courses.put("SER315", new CourseGrades0("SER315"));
        courses.put("SC232", new CourseGrades0("CS232"));

        courses4.put("SER316", new CourseGrades4("SER316"));
        courses4.put("SER315", new CourseGrades4("SER315"));
        courses4.put("SC232", new CourseGrades4("CS232"));
    }
    
    /**Helper method to get courses for main. */
    public static void getCourses() {
        
        courses.get("SER315").set_points("anna", 40);
        courses.get("SER315").set_points("harry", 20);
        courses.get("SER315").set_points("aneesh", 30);
        courses.get("SER315").set_points("rebecca", 10);
        courses.get("SER315").set_points("alex", 30);
        courses.get("SER315").set_points("rose", 15);


        courses4.get("SER315").set_points("anna", 80);
        courses4.get("SER315").set_points("harry", 60);
        courses4.get("SER315").set_points("aneesh", 30);
        courses4.get("SER315").set_points("rebecca", 10);
        courses4.get("SER315").set_points("alex", 30);
        courses4.get("SER315").set_points("rose", 15);
    }
}