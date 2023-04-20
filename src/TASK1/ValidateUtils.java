package TASK1;

public class ValidateUtils {
    public static String checkString(String str) throws RuntimeException {
        if(str==null || str.isEmpty() || str.isBlank()) {
            throw new RuntimeException("Некоректный ввод");
        } else {
            return str;
        }
    }
}
