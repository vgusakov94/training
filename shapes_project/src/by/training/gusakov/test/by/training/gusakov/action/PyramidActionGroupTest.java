package by.training.gusakov.action;

import by.training.gusakov.entity.Pyramid;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PyramidActionGroupTest {
    PyramidAction pyramidAction = new PyramidAction();
    Pyramid pyramid = new Pyramid(4.4, 4.4, 4.4);

    @Test(groups={"unit1"})
    public void testSquare() {
        double actual = pyramidAction.getSquare(pyramid);
        double expected = 37.4231;
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test (groups={"unit1"})
    public void testVolume() {
        double actual = pyramidAction.getVolume(pyramid);
        double expected = 31.857;
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test(groups={"unit2"})
    public void testIsPyramid() {
        Assert.assertTrue(pyramidAction.checkSidesPyramid(pyramid));
    }

}