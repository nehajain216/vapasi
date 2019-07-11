package vapasi.numbers;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NumberToWordsConverterTest
{
    private NumberToWordsConverter converter = new NumberToWordsConverter();

    @Test
    public void shouldReturnNumberInWords()
    {
        Map<Integer,String> numbers = new HashMap<>();
        numbers.put(7,"seven");
        numbers.put(99,"ninety nine");
        numbers.put(300,"three hundred");
        numbers.put(310,"three hundred and ten");
        numbers.put(1000,"one thousand");
        numbers.put(43112603,"forty three million, one hundred and twelve thousand, six hundred and three");

        for (Integer Num : numbers.keySet()) {
            String words = converter.convertToWords(Num);
            assertEquals(numbers.get(Num),words);
        }

    }
}