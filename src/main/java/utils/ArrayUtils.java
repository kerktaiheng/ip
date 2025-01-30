package utils;

import java.util.Arrays;

public class ArrayUtils {
    /**
     * Finds the index of the target element in the array.
     *
     * @param arr the array to search
     * @param target the target element to find
     * @param <T> the type of elements in the array
     * @return the index of the target element, or -1 if not found
     */
    public static <T> int find(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Joins the elements of the array from the specified start index to the end
     * of the array with the given delimiter.
     *
     * @param args the array of strings to join
     * @param delimiter the delimiter to use
     * @param start the start index
     * @return the joined string
     */
    public static String joinFromIndex(String[] args, String delimiter, int start) {
        return String.join(delimiter, Arrays.copyOfRange(args, start, args.length));
    }

    /**
     * Joins the elements of the array from the specified start index to the
     * specified end index with the given delimiter.
     *
     * @param args the array of strings to join
     * @param delimiter the delimiter to use
     * @param start the start index
     * @param end the end index
     * @return the joined string
     */
    public static String joinFromIndex(String[] args, String delimiter, int start, int end) {
        return String.join(delimiter, Arrays.copyOfRange(args, start, end));
    }

    /**
     * Joins the elements of the array from the index of the target element to
     * the end of the array with the given delimiter.
     *
     * @param args the array of strings to join
     * @param delimiter the delimiter to use
     * @param target the target element to find
     * @return the joined string
     */
    public static String joinFromFind(String[] args, String delimiter, String target) {
        int index = find(args, target);
        return joinFromIndex(args, delimiter, index + 1, args.length);
    }

    /**
     * Joins the elements of the array from the index of the start target
     * element to the index of the end target element with the given delimiter.
     *
     * @param args the array of strings to join
     * @param delimiter the delimiter to use
     * @param startTarget the start target element to find
     * @param endTarget the end target element to find
     * @return the joined string
     */
    public static String joinFromFind(String[] args, String delimiter, String startTarget, String endTarget) {
        int start = find(args, startTarget);
        int end = find(args, endTarget);
        return joinFromIndex(args, delimiter, start + 1, end);
    }

}