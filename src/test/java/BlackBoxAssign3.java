import main.java.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class BlackBoxAssign3 {

    private Course courseUnderTest;
    private HashMap<String, String> courseUnderTestExpected = new HashMap<>();

    @Before
    public void setUp() throws Exception {

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


}