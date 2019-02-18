package ru.alexsumin.testcase.util;

import java.util.Random;

public class ProjectUtil {

    private static Random random = new Random();

    public static String generateRandomString(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < size) {
            char c = (char) (random.nextInt(26) + 'a');
            stringBuilder.append(c);
            i++;
        }
        return stringBuilder.toString();
    }
}
