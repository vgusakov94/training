package by.training.gusakov.dataParser;

import by.training.gusakov.exception.DataReaderException;
import by.training.gusakov.parser.DataParser;
import by.training.gusakov.reader.DataReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DataParserTest {
    DataReader reader;
    DataParser parser;

    @BeforeMethod
    public void setUp() {
        reader = new DataReader();
        parser = new DataParser();
    }

    @AfterMethod
    public void tearDown() {
        reader = null;
        parser = null;
    }

    @Test
    public void testParseData() throws DataReaderException {
        String[] str1 = {"3.1", "3.1", "3.1", "6.0", "6.7", "8.9", "1.0"};
        String[] str2 = {"3.4", "6.2", "4.0", "yy.0", "7.8", "9.0", "9.0"};
        String[] str3 = {"4.1", "4.1", "4.1", "6.0", "7.0", "8.9", "8.0"};
        String[] str4 = {"4.0", "3.1", "5.8", "6.0", "7.7", "8.9", "1.0"};
        String[] str5 = {"5.1", "7.1", "5.5", "3.0", "7.4", "6.5", "2.0"};
        String[] str6 = {"uy.0", "3.1", "5.8", "6.0", "7.7", "1.9", "8.0"};
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(str1));
        expected.add(Arrays.asList(str2));
        expected.add(Arrays.asList(str3));
        expected.add(Arrays.asList(str4));
        List<List<String>> actual = parser.parseData(reader.readDataPoint("data/input.txt"));
        assertEquals(expected, actual);
    }

    @Test
    public void testNegativeParseData() throws DataReaderException {
        String[] str1 = {"3.3", "3.1", "-3.1", "6.0", "6.7", "8.9", "1.0"};
        String[] str2 = {"3.5", "6.2", "4.0", "yy.0", "7.8", "9.0", "9.0"};
        String[] str3 = {"4.1", "4.1", "6.1", "6.0", "7.0", "8.9", "8.0"};
        String[] str4 = {"4.67", "3.1", "5.8", "6.0", "7.7", "8.9", "1.0"};
        String[] str5 = {"5.1", "7.1", "5.5", "3.0", "7.4", "6.5", "2.0"};
        String[] str6 = {"uy.67", "3.1", "5.8", "6.0", "7.7", "1.9", "8.0"};
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList(str1));
        expected.add(Arrays.asList(str2));
        expected.add(Arrays.asList(str3));
        expected.add(Arrays.asList(str4));
        List<List<String>> actual = parser.parseData(reader.readDataPoint("data/input.txt"));
        assertEquals(expected, actual);
    }
}