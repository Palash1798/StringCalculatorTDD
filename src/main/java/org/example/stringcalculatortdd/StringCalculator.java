package org.example.stringcalculatortdd;

public class StringCalculator {

    public static int add(String input) {
        if(input.isEmpty()) {
            return 0;
        }

        //code for throwing exception if negative number is present
        String delimiter = ",|\n";
        if (input.matches("//(.*)\n(.*)")) {
            delimiter = Character.toString(input.charAt(2));
            input = input.substring(4);
        }
        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            int num = toInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("Negatives not allowed: " + num);
            }
            sum = sum + num;
        }

        return sum;
    }

    public static int toInt(String number) {
        return Integer.parseInt(number);
    }
}
