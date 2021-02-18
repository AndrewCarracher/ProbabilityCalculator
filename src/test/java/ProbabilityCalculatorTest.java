import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProbabilityCalculatorTest {

    private BigDecimal[] sortedArray;
    private BigDecimal[] unSortedArray;
    private List<BigDecimal> sortedList;
    private List<BigDecimal> unSortedList;
    private BigDecimal result;

    public ProbabilityCalculator calculate;


    @BeforeEach
    public void setUp() {
        this.calculate = new ProbabilityCalculator();

        this.sortedArray = new BigDecimal[]{ new BigDecimal("2"), new BigDecimal("2"), new BigDecimal("3"),
                new BigDecimal("3"), new BigDecimal("4"), new BigDecimal("4"), new BigDecimal("5"),
                new BigDecimal("6"), new BigDecimal("7")};

        this.unSortedArray = new BigDecimal[]{new BigDecimal("2"), new BigDecimal("5"), new BigDecimal("2"),
                new BigDecimal("3"), new BigDecimal("7"), new BigDecimal("3"), new BigDecimal("4"),
                new BigDecimal("8"), new BigDecimal("4"), new BigDecimal("9"), new BigDecimal("5"),
                new BigDecimal("6"), new BigDecimal("7")};

        this.sortedList = Arrays.asList(new BigDecimal("0.2"), new BigDecimal("0.2"), new BigDecimal("0.3"),
                new BigDecimal("0.3"), new BigDecimal("0.4"), new BigDecimal("0.4"), new BigDecimal("0.5"),
                new BigDecimal("0.6"), new BigDecimal("0.7"));

        this.unSortedList = Arrays.asList(new BigDecimal("0.2"), new BigDecimal("0.8"), new BigDecimal("0.3"),
                new BigDecimal("0.9"), new BigDecimal("0.4"), new BigDecimal("0.2"), new BigDecimal("0.5"),
                new BigDecimal("0.1") , new BigDecimal("0.7"));
    }

    // Sum of 1 dataset

    @Test
    void calculatesSumOfDataSetArray() {
        this.result = new BigDecimal("36");

        assertEquals(this.result, calculate.calculateSumOfDataSet(this.sortedArray));
    }
//
    @Test
    void calculatesSumOfDataSetList() {
        this.result = new BigDecimal("3.6");

        assertEquals(this.result, calculate.calculateSumOfDataSet(this.sortedList));
    }

    //   Range of 1 data set

    @Test
    void calculateRangeOfDataSetSortedArray() {
        this.result = new BigDecimal("5");

        assertEquals(this.result, calculate.calculateRangeSortedData(this.sortedArray));
    }

    @Test
    void calculateRangeOfDataSetSortedList() {
        this.result = new BigDecimal("0.5");

        assertEquals(this.result, calculate.calculateRangeSortedData(this.sortedList));
    }

    @Test
    void calculateRangeOfDataSetUnSortedArray() {
        this.result = new BigDecimal("7");

        assertEquals(this.result, calculate.calculateRangeUnSortedData(this.unSortedArray));
    }

    @Test
    void calculateRangeOfDataSetUnSortedList() {
        this.result = new BigDecimal("0.8");

        assertEquals(this.result, calculate.calculateRangeUnSortedData(this.unSortedList));
    }

    //    Averages of 1 data set

    @Test
    void calculatesMeanAverageArray() {
        this.result = new BigDecimal("5.417");

        assertEquals(this.result, calculate.meanAverage(this.unSortedArray));
    }

    @Test
    void calculatesMeanAverageList() {
        this.result = new BigDecimal("0.513");

        assertEquals(this.result, calculate.meanAverage(this.unSortedList));
    }

    @Test
    void calculatesModeAverageArray() {
        List<BigDecimal> resultArray = Arrays.asList(new BigDecimal("7"), new BigDecimal("5"), new BigDecimal("4"),
                new BigDecimal("3"), new BigDecimal("2"));

        assertEquals(resultArray, calculate.modeAverage(this.unSortedArray));
    }

    @Test
    void calculatesModeAverageList() {
        this.result = new BigDecimal("0.2");
        List<BigDecimal> resultArray = Collections.singletonList(this.result);

        assertEquals(resultArray, calculate.modeAverage(this.unSortedList));
    }

    @Test
    void calculatesMedianAverageArraySorted() {
        this.result = new BigDecimal("4");

        assertEquals(this.result, calculate.medianAverageSortedData(this.sortedArray));
    }

    @Test
    void calculatesMedianAverageListSorted() {
        this.result = new BigDecimal("0.4");

        assertEquals(this.result, calculate.medianAverageSortedData(this.sortedList));
    }

    @Test
    void calculatesMedianAverageArrayUnSorted() {
        this.result = new BigDecimal("5");

        assertEquals(this.result, calculate.medianAverageUnSortedData(this.unSortedArray));
    }

    @Test
    void calculatesMedianAverageListUnSorted() {
        this.result = new BigDecimal("0.4");

        assertEquals(this.result, calculate.medianAverageUnSortedData(this.unSortedList));
    }

    // Standard Deviation

    @Test
    void calculatesStandardDeviationList() {
        this.result = new BigDecimal("0.2302");

        assertEquals(this.result, calculate.standardDeviation(this.unSortedList));
    }

    @Test
    void calculatesStandardDeviationArray() {
        this.result = new BigDecimal("1.705");

        assertEquals(this.result, calculate.standardDeviation(this.unSortedArray));
    }

//    // Variance
//
//    @Test
//    void calculatesVariance() {
//
//    }
//
//    @Test
//    void calculatesVariance2() {
//
//    }
//
//    // recognise data distribution type
//
//    @Test
//    void recognisesNormalDistributionData() {
//
//    }
//
//    @Test
//    void recognisesUniformDistributionData() {
//
//    }
//
//    @Test
//    void recognisesCauchyDistributionData() {
//
//    }
//
//    @Test
//    void recognisesTDistributionData() {
//
//    }
//
//    @Test
//    void recognisesFDistributionData() {
//
//    }
//
//    @Test
//    void recognisesChiSquareDistributionData() {
//
//    }
//
//    @Test
//    void recognisesExponentialDistributionData() {
//
//    }
//
//    @Test
//    void recognisesLognormalDistributionData() {
//
//    }
//
//    @Test
//    void recognisesBirnbaumSaundersDistributionData() {
//
//    }
//
//    @Test
//    void recognisesGammaDistributionData() {
//
//    }
//
//    @Test
//    void recognisesDoubleExponentialDistributionData() {
//
//    }
//
//    @Test
//    void recognisesPowerNormalDistributionData() {
//
//    }
//
//    @Test
//    void recognisesPowerLognormalDistributionData() {
//
//    }
//
//    @Test
//    void recognisesTurkeyLambdaDistributionData() {
//
//    }
//
//    @Test
//    void recognisesExtremeValueTypeIDistributionData() {
//
//    }
//
//    @Test
//    void recognisesBetaDistributionData() {
//
//    }
//
//    @Test
//    void recognisesBinomialDistributionData() {
//
//    }
//
//    @Test
//    void recognisesPoissonDistributionData() {
//
//    }
//
//    // Calculate probability Normally Distributed Data
//
//    @Test
//    void calculatesNormalProbabilityCorrectData1() {
//
//    }
//
//    @Test
//    void calculatesNormalProbabilityCorrectData2() {
//
//    }
//
//    @Test
//    void calculatesNormalProbabilityCorrectData3() {
//
//    }
//
//    @Test
//    void calculatesNormalProbabilityErrorStringParam() {
//
//    }
//
//    @Test
//    void calculatesNormalProbabilityErrorIntParam() {
//
//    }
//
//    @Test
//    void calculatesNormalProbabilityErrorBooleanParam() {
//
//    }


}