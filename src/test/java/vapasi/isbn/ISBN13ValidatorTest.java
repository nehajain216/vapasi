package vapasi.isbn;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ISBN13ValidatorTest {

    @Test
    @Parameters({
            "978-0-306-40615-7",
            "978-0 306-40615-7",
            "978 0 306 40615 7",
            "978-0  306-40615-7"
    })
    public void shouldReturnTrueForValidISBNs(String isbn) {
        boolean valid = ISBN13Validator.isValid(isbn);
        assertTrue(valid);
    }

    @Test
    @Parameters({
            "978-0-306-40615_7", //has underscore
            "978-0-306-40A15-7", // has alphabet "A"
            "978-0-306-40615-9", // has incorrect check digit
            "978-0-306-405-7", // length is less than 13
            ""
    })
    public void shouldReturnFalseForInvalidISBNs(String isbn) {
        boolean valid = ISBN13Validator.isValid(isbn);
        assertFalse(valid);
    }
}