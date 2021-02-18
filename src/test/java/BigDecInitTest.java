import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigDecInitTest extends BigDecInit{

    @Test
    void testConvertToBigDecimal() {
        BigDecimal expected = new BigDecimal("4.2");

        assertEquals(expected, convertToBigDecimal(4.2));
    }

    @Test
    void testConvertToBigDecimalArray() {
        Double[] input = {4.2, 7.3, 6.1, 9.5};
        ArrayList<BigDecimal> expected = new ArrayList<>(Arrays.asList(new BigDecimal("4.2"),  new BigDecimal("7.3"),
                new BigDecimal("6.1"), new BigDecimal("9.5")));

        assertEquals(expected, convertToBigDecimal(input));
    }

    @Test
    void testConvertToBigDecimalArrayList() {
        ArrayList<Double> input = new ArrayList<>(Arrays.asList(4.2, 7.3, 6.1, 9.5));
        ArrayList<BigDecimal> expected = new ArrayList<>(Arrays.asList(new BigDecimal("4.2"),  new BigDecimal("7.3"),
                new BigDecimal("6.1"), new BigDecimal("9.5")));

        assertEquals(expected, convertToBigDecimal(input));
    }
}