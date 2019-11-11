import main.java.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class BlackBoxAssign3 {

    private Course courseUnderTest;
    private HashMap<String, String> courseUnderTestExpected = new HashMap<>();
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
    Course curve_15_points_multi;
    HashMap<String, String> curve_15_points_multiExpected = new HashMap<String, String>();
    Course curve_same_names_scores;
    HashMap<String, String> curve_same_names_scoresExpected = new HashMap<String, String>();
    Course negative_scores;
    HashMap<String, String> negative_scoresExpected = new HashMap<String, String>();
    Course extremeNegative_scores;
    HashMap<String, String> extremeNegative_scoresExpected = new HashMap<String, String>();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {

        set_curveTest_20pts();

        //Assignment 2 Created test set ups
        set_centerBoundaryPartition_noCurve();
        set_edgeBoundary_noCurve();
        set_extremes_noCurve_01();
        set_extremes_noCurve_02();
        set_curve_5_points_edges();
        set_curve_15_points_multi();
        set_curve_35_points();
        set_curve_75_points();
        set_negative_scores();
        set_extremeNegative_scores();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void curveTest_20pts() throws IOException {
        System.out.println("Starting curveTest_20pts: ");
        Map<String, String> ans = courseUnderTest.curveLetterGrades();
        for(Map.Entry<String, String> e : ans.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(ans.equals(courseUnderTestExpected));
    }

    /*Assign2 Test Methods */
    @Test
    public void centerBoundaryPartition_noCurve() throws IOException {
        System.out.println("Starting center boundary partition noCurve test: ");
        Map<String, String> cen = centerBoundaryPartition_noCurve.curveLetterGrades();
        for(Map.Entry<String, String> e : cen.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(cen.equals(centerBoundaryPartitionExpected_noCurve));
    }

    @Test
    public void edgeBoundary_noCurve() throws IOException {
        System.out.println("Starting edge boundaris noCurve test: ");
        Map<String, String> edge = edgeBoundary_noCurve.curveLetterGrades();
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(edge.equals(edgeBoundaryExpected_noCurve));
    }

    @Test
    public void extremes_noCurve_01() throws IOException {
        System.out.println("Starting extremes noCurve test 1: ");
        Map<String, String> extr = extremes_noCurve_01.curveLetterGrades();
        for(Map.Entry<String, String> e : extr.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(extr.equals(extremesExpected_01_noCurve));
    }

    @Test
    public void extremes_noCurve_02() throws IOException {
        System.out.println("Starting extremes noCurve test 2:");
        Map<String, String> extr = extremes_noCurve_02.curveLetterGrades();
        for(Map.Entry<String, String> e : extr.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(extr.equals(extremesExpected_02_noCurve));
    }


    @Test
    public void curve_5_points_edges() throws IOException {
        System.out.println("Starting 5 point curve test: ");
        Map<String, String> edge = curve_5_points_edges.curveLetterGrades();
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(edge.equals(curve_5_points_edgesExpected));
    }

    @Test
    public void curve_15_points_multi() throws IOException {
        System.out.println("Starting 15 point curve muli test: ");
        Map<String, String> edge = curve_15_points_multi.curveLetterGrades();
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(edge.equals(curve_15_points_multiExpected));
    }


    @Test
    public void curve_35_points_edges() throws IOException {
        System.out.println("Starting 35 point curve test: ");
        Map<String, String> edge = curve_35_points.curveLetterGrades();
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(edge.equals(curve_35_pointsExpected));
    }

    @Test
    public void curve_75_points_edges() throws IOException {
        System.out.println("Starting 75 point curve test: ");
        Map<String, String> edge = curve_75_points.curveLetterGrades();
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
        assertTrue(edge.equals(curve_75_pointsExpected));
    }

    /**These tests will fail. They are designed to never pass because they throw a
     * negative score input IOException. */
    @Test
    public void negative_scores() throws IOException {

        exception.expect(IOException.class);
        exception.expectMessage("Negative grades were detected. Fix inputs and retry.");

        System.out.println("Starting negative scores test: ");
        Map<String, String> edge = negative_scores.curveLetterGrades();
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
    }

    @Test
    public void extremeNegative_scores() throws IOException {

        exception.expect(IOException.class);
        exception.expectMessage("Negative grades were detected. Fix inputs and retry.");

        System.out.println("Starting extreme negative scores test: ");
        Map<String, String> edge = extremeNegative_scores.curveLetterGrades();
        System.out.println("John's Points: " + extremeNegative_scores.getStudent_Points("John"));
        System.out.println("Sara's Points: " + extremeNegative_scores.getStudent_Points("Sara"));
        System.out.println("Tammie's Points: " + extremeNegative_scores.getStudent_Points("Tammie"));
        for(Map.Entry<String, String> e : edge.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());

        assertTrue(edge.equals(extremeNegative_scoresExpected));
    }


    /* Set up Methods */

    /** Additional prelim test for curveLetterGrades*/
    public void set_curveTest_20pts() throws  Exception{
        courseUnderTest = new Course ("CS101");
        courseUnderTest.set_points("John", 80);
        courseUnderTest.set_points("Sara", 65);
        courseUnderTest.set_points("Sally", 40);
        courseUnderTest.set_points("Arthur", 16);
        courseUnderTest.set_points("Dutch", 10);
        //Expectations
        courseUnderTestExpected.put("John: ", "A");
        courseUnderTestExpected.put("Sara: ", "B");
        courseUnderTestExpected.put("Sally: ", "C");
        courseUnderTestExpected.put("Arthur: ", "D");
        courseUnderTestExpected.put("Dutch: ", "F");
    }

    /**Center check no curve.  Testing all middle boundaries with no curve.
     * Center checks 1-to-1, no curve will occur due to someone getting 100 */
    public void set_centerBoundaryPartition_noCurve() throws Exception {
        centerBoundaryPartition_noCurve = new Course("SER216");
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
        centerBoundaryPartitionExpected_noCurve.put(">100: ", "A");
        centerBoundaryPartitionExpected_noCurve.put("=95: ", "A");
        centerBoundaryPartitionExpected_noCurve.put("=85: ", "B");
        centerBoundaryPartitionExpected_noCurve.put("=75: ", "C");
        centerBoundaryPartitionExpected_noCurve.put("=65: ", "C");
        centerBoundaryPartitionExpected_noCurve.put("=55: ", "D");
        centerBoundaryPartitionExpected_noCurve.put("=45: ", "D");
        centerBoundaryPartitionExpected_noCurve.put("=35: ", "F");
        centerBoundaryPartitionExpected_noCurve.put("=25: ", "F");
        centerBoundaryPartitionExpected_noCurve.put("=15: ", "F");
        centerBoundaryPartitionExpected_noCurve.put("=05: ", "F");
    }

    /**Edge case check no curve.  Testing edge cases with no curve */
    public void set_edgeBoundary_noCurve() throws Exception {
        edgeBoundary_noCurve = new Course("SER215");
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
        edgeBoundaryExpected_noCurve.put("=100: " , "A");
        edgeBoundaryExpected_noCurve.put("=90: "  , "A");
        edgeBoundaryExpected_noCurve.put("=89: "  , "B");
        edgeBoundaryExpected_noCurve.put("=80: "  , "B");
        edgeBoundaryExpected_noCurve.put("=79: "  , "C");
        edgeBoundaryExpected_noCurve.put("=60: "  , "C");
        edgeBoundaryExpected_noCurve.put("=59: "  , "D");
        edgeBoundaryExpected_noCurve.put("=36: "  , "D");
        edgeBoundaryExpected_noCurve.put("=35: "  , "F");

    }

    /** Extremes no curve test 1.  One "zero" grade.  testing curve -
     *  Probably should be F, but will output A */
    public void set_extremes_noCurve_01() throws Exception {
        extremes_noCurve_01 = new Course("Extremes101");
        extremes_noCurve_01.set_points("=0", 0);  //F
        extremesExpected_01_noCurve.put("=0: ", "A");  //TODO
    }

    /**Extremes no curve test 2.  Two grades, 100 and 0.   */
    public void set_extremes_noCurve_02 () throws Exception {
        extremes_noCurve_02 = new Course("Extremes102");
        extremes_noCurve_02.set_points("=100", extremes_noCurve_02.getMaxPoints());  //A
        extremes_noCurve_02.set_points("=0" , 0);  //F
        extremesExpected_02_noCurve.put("=100: ", "A");
        extremesExpected_02_noCurve.put("=0: " , "F");
    }

    /** 5 point curve edge cases */
    public void set_curve_5_points_edges() throws Exception {

        curve_5_points_edges = new Course("CS101");
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
        curve_5_points_edgesExpected.put("=95: ", "A");
        curve_5_points_edgesExpected.put("=85: ", "A");
        curve_5_points_edgesExpected.put("=84: ", "B");
        curve_5_points_edgesExpected.put("=75: ", "B");
        curve_5_points_edgesExpected.put("=74: ", "C");
        curve_5_points_edgesExpected.put("=55: ", "C");
        curve_5_points_edgesExpected.put("=54: ", "D");
        curve_5_points_edgesExpected.put("=31: ", "D");
        curve_5_points_edgesExpected.put("=30: ", "F");
        curve_5_points_edgesExpected.put("=25: ", "F");
    }

    /** 35 point curve test.  Scores out of order */
    public void set_curve_35_points() throws Exception {
        curve_35_points = new Course("CS102");
        curve_35_points.set_points("=65", 65); //A
        curve_35_points.set_points("=55", 55); //A
        curve_35_points.set_points("=54", 54); //B
        curve_35_points.set_points("=25", 25); //C
        curve_35_points.set_points("=7" , 7);   //D
        curve_35_points.set_points("=15", 15); //D
        curve_35_points.set_points("=0" , 0); //F
        //expectations
        curve_35_pointsExpected.put("=65: "   , "A");
        curve_35_pointsExpected.put("=55: "   , "A");
        curve_35_pointsExpected.put("=54: "   , "B");
        curve_35_pointsExpected.put("=25: "   , "C");
        curve_35_pointsExpected.put("=7: "    , "D");
        curve_35_pointsExpected.put("=15: "   , "D");
        curve_35_pointsExpected.put("=0: "    , "F");
    }

    /** 75 point curve test with edge case */
    public void set_curve_75_points() throws Exception {
        curve_75_points = new Course("CS103");
        curve_75_points.set_points("=25", 25); //A
        curve_75_points.set_points("=15", 15); //A
        curve_75_points.set_points("=14", 14); //B
        curve_75_points.set_points("=05", 05); //B
        curve_75_points.set_points("=0" , 0);   //C
        //expectations
        curve_75_pointsExpected.put("=25: ", "A");
        curve_75_pointsExpected.put("=15: ", "A");
        curve_75_pointsExpected.put("=14: ", "B");
        curve_75_pointsExpected.put("=05: ", "B");
        curve_75_pointsExpected.put("=0: " , "C");
    }

    /**Testing 15 point curve duplicate scores high and low*/
    public void set_curve_15_points_multi() throws Exception {
        curve_15_points_multi = new Course("CS201");
        curve_15_points_multi.set_points("Adam", 90); //A
        curve_15_points_multi.set_points("Sara", 90); //A
        curve_15_points_multi.set_points("John", 90); //A
        curve_15_points_multi.set_points("Jim", 26); //D
        curve_15_points_multi.set_points("Angela", 26); //D
        curve_15_points_multi.set_points("James", 25); //F
        curve_15_points_multi.set_points("Devin", 25); //F
        curve_15_points_multi.set_points("Matt", 15); //F
        curve_15_points_multi.set_points("Marissa", 15); //F
        curve_15_points_multi.set_points("Sally" , 0);  //F
        curve_15_points_multi.set_points("Sam" , 0);  //F
        //expectations
        curve_15_points_multiExpected.put("Adam: ", "A");
        curve_15_points_multiExpected.put("Sara: ", "A");
        curve_15_points_multiExpected.put("John: ", "A");
        curve_15_points_multiExpected.put("Jim: ", "D");
        curve_15_points_multiExpected.put("Angela: ", "D");
        curve_15_points_multiExpected.put("James: ", "F");
        curve_15_points_multiExpected.put("Devin: ", "F");
        curve_15_points_multiExpected.put("Matt: ", "F");
        curve_15_points_multiExpected.put("Marissa: ", "F");
        curve_15_points_multiExpected.put("Sally: " , "F");
        curve_15_points_multiExpected.put("Sam: " , "F");
    }

    /**Test negative score input with curve */
    public void set_negative_scores() throws Exception {
        negative_scores = new Course("CS301");
        negative_scores.set_points("John", 50);
        negative_scores.set_points("<0", -1);
        negative_scores.set_points("<-10", -20);
        negative_scores.set_points("<-50", -60);
        //expected
        negative_scoresExpected.put("John: ", "A");
        negative_scoresExpected.put("<0: ", "F");
        negative_scoresExpected.put("<-10: ", "F");
        negative_scoresExpected.put("<-50: ", "F");
    }

    /**Tests extreme negative only cases. */
    public void set_extremeNegative_scores() throws Exception {
        extremeNegative_scores =  new Course("CS302");
        extremeNegative_scores.set_points("John: ", -180);
        extremeNegative_scores.set_points("Sara: ", -95);
        extremeNegative_scores.set_points("Tammie: ", -80);

        //expected
        extremeNegative_scoresExpected.put("John: ", "F");
        extremeNegative_scoresExpected.put("Sara: ", "F");
        extremeNegative_scoresExpected.put("Tammie: ", "F");
    }

}