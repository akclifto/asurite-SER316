import main.java.Course;
import main.java.Major;
import main.java.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CourseTest {

    Course oneStudent;

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void addDropStudentTest(){
        //add
        Student s1 = new Student("2144", Major.CS);
        Course c1 = new Course ("CSE101");
        c1.addStudent(s1);
        assertTrue(c1.getStudents().size() == 2);
        assertTrue(!c1.addStudent(s1));
        //drop
        c1.dropStudent("2144");
        assertTrue(c1.getStudents().get(0) == s1);
    }



}
