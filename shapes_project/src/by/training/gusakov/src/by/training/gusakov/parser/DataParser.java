package by.training.gusakov.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.DoubleStream;

import by.training.gusakov.validator.PyramidValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static by.training.gusakov.validator.PyramidValidator.DATA_POINTS;

public class DataParser {

    static final Logger logger = LogManager.getRootLogger();
    private static String delimiter = "//s+";

    public String parseData(final String dataPoints) {
        List<String> pointsCoordinate = new ArrayList<>();
        PyramidValidator pyramidValidator = new PyramidValidator();
        if (pyramidValidator.isValidPyramidData(dataPoints)) {
            Matcher matcher = DATA_POINTS.matcher(dataPoints);
            pointsCoordinate.add(matcher.group());
        } else {
            logger.warn("Invalid  data");
        }
        DoubleStream arrayPointsCoordinates = pointsCoordinate.stream().mapToDouble(Double::parseDouble);
        logger.debug("String parsed");
        return Arrays.toString(String.valueOf(arrayPointsCoordinates).split(delimiter));
    }

    public List<List<String>> parseData(List<String> readDataPoint) {
        return parseData(readDataPoint);
    }

}