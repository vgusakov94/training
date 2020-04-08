package by.training.gusakov.action;

import by.training.gusakov.entity.Pyramid;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PyramidAction {
    private static final Logger logger = LogManager.getRootLogger();

    public double getSquare(Pyramid pyramid) {
        double square;
        square = 1.5 * pyramid.getSideB() * pyramid.getSideC() + Math.sqrt(3) / 4 * Math.pow(pyramid.getSideD(), 2);
        return square;
    }

    public double getVolume(Pyramid pyramid) {
        double volume;
        volume = pyramid.getSideD() * 2 * Math.pow(pyramid.getSideB(), 2) / 12 * Math.sqrt(3);
        return volume;
    }

    public boolean checkSidesPyramid(Pyramid pyramid) {
        boolean result = false;
        if (pyramid.getSideB() == pyramid.getSideC() && pyramid.getSideB() == pyramid.getSideD()) {
            result = true;
            logger.info("It is a regular pyramid");
        }
        return result;
    }

}
