package hexlet.code;

public class Utils {

    public static int generateNumber(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    public static String getArrayRandom(String[] array) {
        return array[generateNumber(0, array.length - 1)];
    }

    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        final int limit = (int) Math.sqrt(number);
        final int firstDivider = 3;
        var divider = firstDivider;
        while (divider <= limit) {
            if (number % divider == 0) {
                return false;
            }
            divider += 2;
        }
        return true;
    }
}
