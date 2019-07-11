package vapasi.numbers;

public class NumberToWordsConverter {

    private static final String[] specialUnits = {
            ""," thousand,"," million,"," billion,"," trillion,"
    };

    private static final String[] tensUnits = {
            "", " ten", " twenty"," thirty", " forty"," fifty",
            " sixty", " seventy", " eighty", " ninety"
    };

    private static final String[] numberUnits = {
            "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",
            " eleven"," twelve", " thirteen", " fourteen", " fifteen",
            " sixteen", " seventeen", " eighteen", " nineteen"
    };

    public String convertToWords(int number) {

        if (number == 0) { return "zero"; }

        String current = "";
        int place = 0;

        do {
            int n = number % 1000;
            if (n != 0){
                String s = convertThousandSegment(n);
                current = s + specialUnits[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        if(current.charAt(current.length()-1) == ',')
        {
           return current.substring(0,current.length()-1).trim();
        }
        else
        {
            return current.trim();
        }

    }

    private String convertThousandSegment(int number) {
        String current;

        if (number % 100 < 20){
            current = numberUnits[number % 100];
            number /= 100;
        }
        else {
            current = numberUnits[number % 10];
            number /= 10;

            current = tensUnits[number % 10] + current;
            number /= 10;
        }
        if (number == 0)
        {
            return current;
        }
        if(current.equals(""))
        {
            return numberUnits[number] + " hundred" + current;
        }
        return numberUnits[number] + " hundred and" + current;
    }
}
