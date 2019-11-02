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
    //samples from assignment 2
    Course oneStudent;
    HashMap<String, String> oneStudentExpected = new HashMap<String, String>();
    Course happyDayGradeBoundary;
    HashMap<String, String> happyDayGradeBoundaryExpected = new HashMap<String, String>();
    //no curve tests
    Course centerBoundaryPartition_noCurve;
    HashMap<String, String> centerBoundaryPartitionExpected_noCurve = new HashMap<String, String>();
    Course edgeBoundary_noCurve;
    HashMap<String, String> edgeBoundaryExpected_noCurve = new HashMap<String, String>();
    Course extremes_noCurve_01;
    HashMap<String, String> extremesExpected_01_noCurve = new HashMap<String, String>();
    Course extremes_noCurve_02;
    HashMap<String, String> extremesExpected_02_noCurve = new HashMap<String, String>();
    //curve tests
    Course curve_5_points_edges;
    HashMap<String, String> curve_5_points_edgesExpected = new HashMap<String, String>();
    Course curve_35_points;
    HashMap<String, String> curve_35_pointsExpected = new HashMap<String, String>();
    Course curve_75_points;
    HashMap<String, String> curve_75_pointsExpected = new HashMap<String, String>();

    @Before
    public void setUp() throws Exception {

        /** Sample Tests included in assignment */
        // One Student
        // all courses should be created like this
        // Course created with two Students having
        oneStudent = createCourse("SER316");
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

        //Assignment 2 Created test set ups
        set_centerBoundaryPartition_noCurve();
        set_edgeBoundary_noCurve();
        set_extremes_noCurve_01();
        set_extremes_noCurve_02();
        set_curve_5_points_edges();
        set_curve_35_points();
        set_curve_75_points();


    }

    @After
    public void tearDown() throws Exception {
    }

    /*Test Methods */
    @Test
    public void centerBoundaryPartition_noCurve(){
        Map<String, String> cen = centerBoundaryPartition_noCurve.curveLetterGrades();
        for(Map.Entry<String, String> e : cen.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(cen.equals(centerBoundaryPartitionExpected_noCurve));
    }

    @Test
    public void edgeBoundary_noCurve(){
        Map<String, String> edge = edgeBoundary_noCurve.curveLetterGrades();
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(edge.equals(edgeBoundaryExpected_noCurve));
    }

    @Test
    public void extremes_noCurve_01(){
        Map<String, String> extr = extremes_noCurve_01.curveLetterGrades();
        for(Map.Entry<String, String> e : extr.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(extr.equals(extremesExpected_01_noCurve));
    }

    @Test
    public void extremes_noCurve_02(){
        Map<String, String> extr = extremes_noCurve_02.curveLetterGrades();
        for(Map.Entry<String, String> e : extr.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(extr.equals(extremesExpected_02_noCurve));
    }


    @Test
    public void curve_5_points_edges(){
        Map<String, String> edge = curve_5_points_edges.curveLetterGrades();
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(edge.equals(curve_5_points_edgesExpected));
    }

    @Test
    public void curve_35_points_edges(){
        Map<String, String> edge = curve_35_points.curveLetterGrades();
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(edge.equals(curve_35_pointsExpected));
    }

    @Test
    public void curve_75_points_edges(){
        Map<String, String> edge = curve_75_points.curveLetterGrades();
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(edge.equals(curve_75_pointsExpected));
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


    /* Set up Methods */
    /**Center check no curve.  Testing all middle boundaries with no curve.
     * Center checks 1-to-1, no curve will occur due to someone getting 100 */
    public void set_centerBoundaryPartition_noCurve() throws Exception {
        centerBoundaryPartition_noCurve = createCourse("SER216");
        centerBoundaryPartition_noCurve.set_points(">100", 110); //A
        centerBoundaryPartition_noCurve.set_points("=95", 95); //A
        centerBoundaryPartition_noCurve.set_points("=85", 85); //B
        centerBoundaryPartition_noCurve.set_points("=75", 75); //C
        centerBoundaryPartition_noCurve.set_points("=65", 65); //C
        centerBoundaryPartition_noCurve.set_points("=55", 55); //D
        centerBoundaryPartition_noCurve.set_points("=45", 45); //D
        centerBoundaryPartition_noCurve.set_points("=35", 35); //F
        centerBoundaryPartition_noCurve.set_points("=25", 25); //F
        centerBoundaryPartition_noCurve.set_points("=15", 15); //F
        centerBoundaryPartition_noCurve.set_points("=05", 05); //F
        //Center Boundary expectation
        centerBoundaryPartitionExpected_noCurve.put(">100", "A");
        centerBoundaryPartitionExpected_noCurve.put("=95", "A");
        centerBoundaryPartitionExpected_noCurve.put("=85", "B");
        centerBoundaryPartitionExpected_noCurve.put("=75", "C");
        centerBoundaryPartitionExpected_noCurve.put("=65", "C");
        centerBoundaryPartitionExpected_noCurve.put("=55", "D");
        centerBoundaryPartitionExpected_noCurve.put("=45", "D");
        centerBoundaryPartitionExpected_noCurve.put("=35", "F");
        centerBoundaryPartitionExpected_noCurve.put("=25", "F");
        centerBoundaryPartitionExpected_noCurve.put("=15", "F");
        centerBoundaryPartitionExpected_noCurve.put("=05", "F");
    }

    /**Edge case check no curve.  Testing edge cases with no curve */
    public void set_edgeBoundary_noCurve() throws Exception {
        edgeBoundary_noCurve = createCourse("SER215");
        edgeBoundary_noCurve.set_points("=100", edgeBoundary_noCurve.getMaxPoints()); //A
        edgeBoundary_noCurve.set_points("=90", 90); //A
        edgeBoundary_noCurve.set_points("=89", 89); //B
        edgeBoundary_noCurve.set_points("=80", 80); //B
        edgeBoundary_noCurve.set_points("=79", 79); //C
        edgeBoundary_noCurve.set_points("=60", 60); //C
        edgeBoundary_noCurve.set_points("=59", 59); //D
        edgeBoundary_noCurve.set_points("=36", 36); //D
        edgeBoundary_noCurve.set_points("=35", 35); //F
        //edge boundary expectation
        edgeBoundaryExpected_noCurve.put("=100", "A");
        edgeBoundaryExpected_noCurve.put("=90", "A");
        edgeBoundaryExpected_noCurve.put("=89", "B");
        edgeBoundaryExpected_noCurve.put("=80", "B");
        edgeBoundaryExpected_noCurve.put("=79", "C");
        edgeBoundaryExpected_noCurve.put("=60", "C");
        edgeBoundaryExpected_noCurve.put("=59", "D");
        edgeBoundaryExpected_noCurve.put("=36", "D");
        edgeBoundaryExpected_noCurve.put("=35", "F");

    }

    /** Extremes no curve test 1.  One "zero" grade.  testing curve -
     *  Probably should be F, but will output A */
    public void set_extremes_noCurve_01() throws Exception {
        extremes_noCurve_01 = createCourse("Extremes101");
        extremes_noCurve_01.set_points("=0", 0);  //F
        extremesExpected_01_noCurve.put("=0", "F");
    }

    /**Extremes no curve test 2.  Two grades, 100 and 0.   */
    public void set_extremes_noCurve_02 () throws Exception {
        extremes_noCurve_02 = createCourse("Extremes102");
        extremes_noCurve_02.set_points("=100", extremes_noCurve_02.getMaxPoints());  //A
        extremes_noCurve_02.set_points("=0", 00);  //F
        extremesExpected_02_noCurve.put("=100", "A");
        extremesExpected_02_noCurve.put("=00", "F");
    }

    /** 5 point curve edge cases */
    public void set_curve_5_points_edges() throws Exception {

        curve_5_points_edges = createCourse("CS101");
        curve_5_points_edges.set_points("=95", 95); //A
        curve_5_points_edges.set_points("=85", 85); //A
        curve_5_points_edges.set_points("=84", 84); //B
        curve_5_points_edges.set_points("=75", 75); //B
        curve_5_points_edges.set_points("=74", 74); //C
        curve_5_points_edges.set_points("=55", 55); //C
        curve_5_points_edges.set_points("=54", 54); //D
        curve_5_points_edges.set_points("=31", 31); //D
        curve_5_points_edges.set_points("=30", 30); //F
        curve_5_points_edges.set_points("=25", 25); //F
        //expectations
        curve_5_points_edgesExpected.put("=95", "A");
        curve_5_points_edgesExpected.put("=85", "A");
        curve_5_points_edgesExpected.put("=84", "B");
        curve_5_points_edgesExpected.put("=75", "B");
        curve_5_points_edgesExpected.put("=74", "C");
        curve_5_points_edgesExpected.put("=55", "C");
        curve_5_points_edgesExpected.put("=54", "D");
        curve_5_points_edgesExpected.put("=31", "D");
        curve_5_points_edgesExpected.put("=30", "F");
        curve_5_points_edgesExpected.put("=25", "F");
    }

    /** 35 point curve test.  Scores out of order */
    public void set_curve_35_points() throws Exception {
        curve_35_points = createCourse("CS102");
        curve_35_points.set_points("=65", 65); //A
        curve_35_points.set_points("=55", 55); //A
        curve_35_points.set_points("=54", 54); //B
        curve_35_points.set_points("=25", 25); //C
        curve_35_points.set_points("=7", 7);   //D
        curve_35_points.set_points("=15", 15); //D
//        curve_35_points.set_points("=0", 0); //F
        //expectations
        curve_35_pointsExpected.put("65", "A");
        curve_35_pointsExpected.put("55", "A");
        curve_35_pointsExpected.put("54", "B");
        curve_35_pointsExpected.put("25", "C");
        curve_35_pointsExpected.put("7", "D");
        curve_35_pointsExpected.put("15",  "D");
//        curve_35_pointsExpected.put("0",  "F");
    }

    /** 75 point curve test */
    public void set_curve_75_points() throws Exception {
        curve_75_points = createCourse("CS103");
        curve_75_points.set_points("=25", 65); //A
        curve_75_points.set_points("=15", 75); //A
        curve_75_points.set_points("=14", 54); //B
        curve_75_points.set_points("=05", 55); //B
        curve_75_points.set_points("=0", 7);   //C
        //expectations
        curve_75_pointsExpected.put("25", "A");
        curve_75_pointsExpected.put("15", "A");
        curve_75_pointsExpected.put("14", "B");
        curve_75_pointsExpected.put("05", "B");
        curve_75_pointsExpected.put("0", "C");

    }


}
