package utils;

import org.testng.Assert;

public class AssertionUtil {

    public static void verifyTrue(boolean condition,String message) {

        Assert.assertTrue(condition,message);
    }
}