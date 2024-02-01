package hexlet.code;

public class Utils {
    public static int generateNumber(int minValue, int maxValue) {
        return (int) ((maxValue - minValue) * Math.random() + minValue);
    }

    public static int generateNumber(int maxValue) {
        return generateNumber(0, maxValue);
    }
}
