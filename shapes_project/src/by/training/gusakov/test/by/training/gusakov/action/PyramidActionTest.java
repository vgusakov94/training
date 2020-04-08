package by.training.gusakov.action;

import by.training.gusakov.entity.Pyramid;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PyramidActionTest {
    PyramidAction pyramidAction = new PyramidAction();
    Pyramid pyramid = new Pyramid(3.4, 3.4, 3.4);

    @Test
    public void squarePyramidPositiveTest() {
        double actual = pyramidAction.getSquare(pyramid);
        double expected = 22.3456;
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void squarePyramidNegativeTest() {
        double actual = pyramidAction.getSquare(pyramid);
        double expected = 10.857;
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void volumePyramidNegativeTes() {
        double actual = pyramidAction.getVolume(pyramid);
        double expected = 31.857;
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void volumePyramidPositiveTest() {
        double actual = pyramidAction.getVolume(pyramid);
        double expected = 11.346;
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testIsPyramid() {
        Assert.assertTrue(pyramidAction.checkSidesPyramid(pyramid));
    }
}