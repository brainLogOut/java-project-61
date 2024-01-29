package hexlet.code;

public class Utils {
    public static int genNumber(int minValue, int maxValue) {
        return (int) ((maxValue - minValue) * Math.random() + minValue);
    }
}
