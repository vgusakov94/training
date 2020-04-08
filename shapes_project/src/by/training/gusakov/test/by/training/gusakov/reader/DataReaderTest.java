package by.training.gusakov.reader;

import by.training.gusakov.exception.DataReaderException;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;


public class DataReaderTest {
    DataReader reader;

    @BeforeMethod
    public void setUp() {
        reader = new DataReader();

    }

    @AfterMethod
    public void tearDown() {
        reader = null;
    }

    @Test(dataProvider = "readingData")
    public void testReadDataPoint(List<String> expected, String filepath) throws DataReaderException {
        List<String> actual = reader.readDataPoint(filepath);
        assertEquals(actual, expected);

    }

    private void assertEquals(List<String> actual, List<String> expected) {
    }

    @DataProvider(name = "readingData")
    public Object[][] readingData() {
        List<String> lines = new ArrayList<>();
        lines.add("3.1 3.1 3.1 6.0 6.7 8.9 1.0");
        lines.add("3.4 6.2 4.0 yy.0 7.8 9.0 9.0");
        lines.add("4.2 4.1 6.1 6.0 7.0 8.9 8.0");
        lines.add("4.0 3.1 5.8 6.0 7.7 8.9 1.0");
        lines.add("5.1 7.1 5.5 3.0 7.4 6.5 2.0");
        lines.add("uy.0 3.1 5.8 6.0 7.7 1.9 8.0");
        return new Object[][]{
                {lines, "data/input.txt"}
        };
    }
}
