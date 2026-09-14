package park.util;

public final class NumberUtil {
    private NumberUtil() {}
    public static int parseInt(String s, String field) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { throw new IllegalArgumentException(field + " must be a whole number"); }
    }
    public static double parseDouble(String s, String field) {
        try { return Double.parseDouble(s.trim()); } catch (Exception e) { throw new IllegalArgumentException(field + " must be a number"); }
    }
}
