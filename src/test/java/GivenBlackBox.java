import main.java.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class GivenBlackBox {
    private Class<Course> classUnderTest;

    @SuppressWarnings("unchecked")
    public GivenBlackBox(Object classUnderTest) {

        this.classUnderTest = (Class<Course>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = {
                {CourseGrades0.class},
                {CourseGrades1.class},
                {CourseGrades2.class},
                {CourseGrades3.class},
                {CourseGrades4.class},
                {CourseGrades5.class}

        };
        return Arrays.asList(classes);
    }

    private Course createCourse(String name) throws Exception {
        Constructor<Course> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }

    Course oneStudent;
    HashMap<String, String> oneStudentExpected = new HashMap<String, String>();

    Course happyDayGradeBoundary;
    HashMap<String, String> happyDayGradeBoundaryExpected = new HashMap<String, String>();

    Course centerBoundaryPartition;
    HashMap<String, String> centerBoundaryPartitionExpected = new HashMap<String, String>();

    @Before
    public void setUp() throws Exception {

        // One Student
        // all courses should be created like this
        // Course created with two Students having
        oneStudent = createCourse("SER316");
//        oneStudent = createCourse("CSE101");

        // this would be the expected result after the method countOccurencesLetterGrades is called
        oneStudent.set_points("Hanna", 50);
        oneStudentExpected.put("Hanna", "A");


        // Happy Day Case Grade Boundaries
        // Four Students mix of grades
        happyDayGradeBoundary = createCourse("SER315");
        happyDayGradeBoundary.set_points("100"  , 100); //A
        happyDayGradeBoundary.set_points(">89"  , 90);  //A
        happyDayGradeBoundary.set_points(">79"  , 89);  //B
        happyDayGradeBoundary.set_points(">59"  , 79);  //C
        happyDayGradeBoundary.set_points(">35"  , 59);  //D
        happyDayGradeBoundary.set_points("<=35" , 35);  //F
        //expected result
        happyDayGradeBoundaryExpected.put("100"  , "A");
        happyDayGradeBoundaryExpected.put(">89"  , "A");
        happyDayGradeBoundaryExpected.put(">79"  , "B");
        happyDayGradeBoundaryExpected.put(">59"  , "C");
        happyDayGradeBoundaryExpected.put(">35"  , "D");
        happyDayGradeBoundaryExpected.put("<=35" , "F");


        //Center checks 1-to-1, no curve will occur due to someone getting 100
        centerBoundaryPartition = createCourse("SER216");
        centerBoundaryPartition.set_points(">100", 110); //A
        centerBoundaryPartition.set_points("=95", 95); //A
        centerBoundaryPartition.set_points("=85", 85); //B
        centerBoundaryPartition.set_points("=75", 75); //C
        centerBoundaryPartition.set_points("=65", 65); //C
        centerBoundaryPartition.set_points("=55", 55); //D
        centerBoundaryPartition.set_points("=45", 45); //D
        centerBoundaryPartition.set_points("=35", 35); //F
        centerBoundaryPartition.set_points("=25", 25); //F
        centerBoundaryPartition.set_points("=15", 15); //F
        centerBoundaryPartition.set_points("=05", 05); //F

        //Center Boundary expectation
        centerBoundaryPartitionExpected.put(">100", "A");
        centerBoundaryPartitionExpected.put("=95", "A");
        centerBoundaryPartitionExpected.put("=85", "B");
        centerBoundaryPartitionExpected.put("=75", "C");
        centerBoundaryPartitionExpected.put("=65", "C");
        centerBoundaryPartitionExpected.put("=55", "D");
        centerBoundaryPartitionExpected.put("=45", "D");
        centerBoundaryPartitionExpected.put("=35", "F");
        centerBoundaryPartitionExpected.put("=25", "F");
        centerBoundaryPartitionExpected.put("=15", "F");
        centerBoundaryPartitionExpected.put("=05", "F");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void three_pt_boundary_check(){

    }

    @Test
    public void center_check_no_curve(){
        Map<String, String> cen = centerBoundaryPartition.curveLetterGrades();
        for(Map.Entry<String, String> e : cen.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(cen.equals(centerBoundaryPartitionExpected));
    }


    // sample test
    @Test
    public void oneStudent() {
        Map<String, String> ans = oneStudent.curveLetterGrades();
        for(Map.Entry<String, String> e : ans.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(ans.equals(oneStudentExpected));
    }

    // sample test2
    @Test
    public void happyDayGradeBoundaries() {
        Map<String, String> ans = happyDayGradeBoundary.curveLetterGrades();
        for(Map.Entry<String, String> e : ans.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(ans.equals(happyDayGradeBoundaryExpected));
    }



}
