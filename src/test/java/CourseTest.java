import main.java.Course;
import main.java.Major;
import main.java.Student;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class CourseTest {

    Course oneStudent;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
    }


    /** Test cases for Task 3: Step 2, Part 3
     * Testing Node and Edge Coverage based on line colors in document.
     *  */
    @Test
    public void TestRed() throws IOException {

        oneStudent = new Course ("SER316");
        oneStudent.set_points("Sally", 34);
        oneStudent.set_points("Sara", 36);
        oneStudent.set_points("Arthur", 60);
        oneStudent.set_points("John", 80);
        oneStudent.set_points("Dutch", 90);
        HashMap<String, Integer> ans = oneStudent.countOccurencesLetterGrades(false);
        assertTrue(ans.get("A") == 1);
        assertTrue(ans.get("B") == 1);
        assertTrue(ans.get("C") == 1);
        assertTrue(ans.get("D") == 1);
        assertTrue(ans.get("F") == 1);
    }

    @Test
    public void TestYellow() throws NullPointerException, IOException {

        oneStudent = new Course ("CSE101");
        exception.expect(NullPointerException.class);
        HashMap<String, Integer> ans = oneStudent.countOccurencesLetterGrades(false);
    }

    @Test
    public void TestOrange() throws IOException {
        oneStudent = new Course ("CSE102");
        oneStudent.set_points("Sally", 34);
        oneStudent.set_points("Sara", 36);
        oneStudent.set_points("Arthur", 60);
        oneStudent.set_points("John", 80);
        oneStudent.set_points("Dutch", 100);
        HashMap<String, Integer> ans = oneStudent.countOccurencesLetterGrades(true);
        assertTrue(ans.get("A") == 1);
        assertTrue(ans.get("B") == 1);
        assertTrue(ans.get("C") == 1);
        assertTrue(ans.get("D") == 1);
        assertTrue(ans.get("F") == 1);

    }

    /** Test case for Task 3: Step 2, Part 5
     * Testing addstudent and dropStudent
     * */

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
