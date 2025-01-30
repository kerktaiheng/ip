package utils;

import java.util.Arrays;

public class ArrayUtils {
    public static <T> int find(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static String joinFromIndex(String[] args, String delimiter, int start) {
        return String.join(delimiter, Arrays.copyOfRange(args, start, args.length));
    }

    public static String joinFromIndex(String[] args, String delimiter, int start, int end) {
        return String.join(delimiter, Arrays.copyOfRange(args, start, end));
    }

    public static String joinFromFind(String[] args, String delimiter, String target) {
        int index = find(args, target);
        return joinFromIndex(args, delimiter, index + 1, args.length);
    }

    public static String joinFromFind(String[] args, String delimiter, String startTarget, String endTarget) {
        int start = find(args, startTarget);
        int end = find(args, endTarget);
        return joinFromIndex(args, delimiter, start + 1, end);
    }

}