package by.training.gusakov.validator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public class PyramidValidator {
    private static final Logger logger = LogManager.getRootLogger();
    public static final Pattern DATA_POINTS = Pattern.compile("^[\\d]+[.][\\d]+\\s[\\d]+[.][\\d]+\\s[\\d]+" +
            "[.][\\d]+\\s[\\d]+[.][\\d]+\\s[\\d]+[.][\\d]+\\s[\\d]+[.][\\d]+\\s[\\d]+[.][\\d]+$");

    public boolean isValidPyramidData(final String text) {
        final boolean result = DATA_POINTS.matcher(text).matches();
        logger.debug("String is " + result);
        return result;
    }
}
