import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private BigDecimal[] unSortedArr;
    private BigDecimal[] sortedArr;
    private List<BigDecimal> sortedList;
    private List<BigDecimal> unSortedList;

    @BeforeEach
    public void setUp() {
        this.unSortedArr = new BigDecimal[] { new BigDecimal("0.1"), new BigDecimal("7.6"), new BigDecimal("3.6"),
                new BigDecimal("2.8"), new BigDecimal("7.6"), new BigDecimal("4.9"), new BigDecimal("6.2") };

        this.sortedArr = new BigDecimal[] { new BigDecimal("0.1"), new BigDecimal("2.8"), new BigDecimal("3.6"),
                new BigDecimal("4.9"), new BigDecimal("6.2") , new BigDecimal("7.6"),  new BigDecimal("7.6") };

        this.unSortedList = Arrays.asList(new BigDecimal("0.1"), new BigDecimal("7.6"), new BigDecimal("3.6"),
                new BigDecimal("2.8"), new BigDecimal("7.6"), new BigDecimal("4.9"), new BigDecimal("6.2"));

        this.sortedList = Arrays.asList(new BigDecimal("0.1"), new BigDecimal("2.8"), new BigDecimal("3.6"),
                new BigDecimal("4.9"), new BigDecimal("6.2") , new BigDecimal("7.6"),  new BigDecimal("7.6"));
    }

    @Test
    void quickSortArray() {
        BigDecimal[] finalArr = QuickSort.quickSort(this.unSortedArr, 0, this.unSortedArr.length -1);
        for (int i =0; i < this.sortedArr.length; i++) {

            assertEquals(this.sortedArr[i], finalArr[i]);
        }
    }

    @Test
    void quickSortArrayList() {
        assertEquals(this.sortedList, QuickSort.quickSort(this.unSortedList, 0, this.unSortedList.size() -1));
    }
}