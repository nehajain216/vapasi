package vapasi.isbn;

public class ISBN13Validator {

    public static boolean isValid(String value) {
        String isbn = cleanUp(value);

        if (!isValidFormat(isbn)) {
            return false;
        } else {
            int[] numbers = getAsIntArray(isbn);
            int givenCheckDigit = numbers[12];
            return givenCheckDigit == calculateCheckDigit(numbers);
        }
    }

    private static String cleanUp(String isbn) {
        // Remove hyphen and space characters
        return isbn.replaceAll(" ", "").replaceAll("-", "");
    }

    private static boolean isValidFormat(String isbn) {
        // validate length and contains only digit
        return (isbn.length() == 13 && isbn.matches("[0-9]+"));
    }

    private static int calculateCheckDigit(int[] numbers) {
        int odd = numbers[0] + numbers[2] + numbers[4] + numbers[6] + numbers[8] + numbers[10];
        int even = (numbers[1] + numbers[3] + numbers[5] + numbers[7] + numbers[9] + numbers[11]) * 3;

        int sum = odd + even;
        int modValue = sum % 10;
        int val1 = 10 - modValue;
        return val1 % 10;
    }

    private static int[] getAsIntArray(String isbn) {
        int[] numbers = new int[isbn.length()];
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);
            numbers[i] = Integer.parseInt(String.valueOf(c));
        }
        return numbers;
    }

}
