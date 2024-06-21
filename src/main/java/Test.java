import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        double number = 10.123456789;

        // Round the number to two decimal places
        double roundedNumber = Math.round(number * 100.0) / 100.0;

        System.out.println("Rounded number: " + roundedNumber); // Outputs "Rounded number: 10.12"

    }
}
