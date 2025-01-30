package utils;

import java.time.LocalDateTime;
import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static int getRandomInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int getRandomInt(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }

    public static double getRandomDouble() {
        return RANDOM.nextDouble();
    }

    public static double getRandomDouble(double min, double max) {
        return RANDOM.nextDouble() * (max - min) + min;
    }

    public static boolean getRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public static String getRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(RANDOM.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static LocalDateTime getRandomDateTime() {
        int year = getRandomInt(2000, 2022);
        int month = getRandomInt(1, 13);
        int day = getRandomInt(1, 29);
        int hour = getRandomInt(0, 24);
        int minute = getRandomInt(0, 60);
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public static String getRandomDateTimeString() {
        LocalDateTime dateTime = getRandomDateTime();
        return DateTimeUtils.formatDateTime(dateTime);
    }

}
