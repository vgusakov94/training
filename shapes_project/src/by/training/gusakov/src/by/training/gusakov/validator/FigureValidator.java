package by.training.gusakov.validator;

import by.training.gusakov.entity.Pyramid;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FigureValidator {

    private static final Logger logger = LogManager.getRootLogger();

    public boolean checkValidSides(Pyramid pyramid) {

        if (pyramid.getSideB() <= 0 || pyramid.getSideC() <= 0 || pyramid.getSideD() <= 0) {
            logger.error("Pyramid's sides can't be <=0");
        }
        return false;
    }

}