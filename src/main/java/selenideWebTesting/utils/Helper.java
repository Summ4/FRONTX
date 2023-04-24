package selenideWebTesting.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Helper {

    public String getRandomString() {

        return RandomStringUtils.random(10, true, false);

    }
}
