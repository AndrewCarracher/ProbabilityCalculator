import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProbabilityCalculator extends QuickSort {

    public ProbabilityCalculator() {}

    // Sum of 1 data set

    public BigDecimal calculateSumOfDataSet(BigDecimal[] data) {
        BigDecimal sum = new BigDecimal("0");
        for (BigDecimal datum : data) {
            sum = sum.add(datum);
        }

        return sum;
    }

    public BigDecimal calculateSumOfDataSet(List<BigDecimal> data) {
        BigDecimal sum = new BigDecimal("0");
        for (Number datum : data) {
            sum = sum.add((BigDecimal) datum);
        }

        return sum;
    }

    // Range

    public BigDecimal calculateRangeSortedData(BigDecimal[] data) {
        int size = data.length -1;

        return data[size].subtract(data[0]);
    }

    public BigDecimal calculateRangeSortedData(List<BigDecimal> data) {
        int size = data.size() -1;

        return data.get(size).subtract(data.get(0));
    }

//    // unsorted

    public BigDecimal calculateRangeUnSortedData(BigDecimal[] data) {
        int size = data.length -1;

        BigDecimal[] sortedData = QuickSort.quickSort(data, 0, size);

        return sortedData[size].subtract(sortedData[0]);
    }

    public BigDecimal calculateRangeUnSortedData(List<BigDecimal> data) {
        int size = data.size() -1;

        List<BigDecimal> sortedData = QuickSort.quickSort(data, 0, size);

        return sortedData.get(size).subtract(sortedData.get(0));
    }

    // Mean Averages

    public BigDecimal meanAverage(BigDecimal[] data) {
        BigDecimal aveResult;
        try {
            int dataSize = data.length - 1;
            BigDecimal size = new BigDecimal(Integer.toString(dataSize));
            aveResult = calculateSumOfDataSet(data).divide(size, 3, RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        }

        return aveResult;
    }

    public BigDecimal meanAverage(List<BigDecimal> data) {
        BigDecimal aveResult;
        try {
            int dataSize = data.size() - 1;
            BigDecimal size = new BigDecimal(Integer.toString(dataSize));
            aveResult = calculateSumOfDataSet(data).divide(size, 3, RoundingMode.HALF_UP);
        } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        }

        return aveResult;
    }

    // Mode Averages
    // if only 1 of each there's no mode
    // can be multiple modes

    public List<BigDecimal> modeAverage(List<BigDecimal> data) {
        int count = 0;
        BigDecimal zero = new BigDecimal("0");
        List<BigDecimal> aveResult = new java.util.ArrayList<>(Collections.singletonList(zero));

        HashMap<BigDecimal, Integer> hm = new HashMap<>();

        for (BigDecimal datum : data) {
            hm.merge(datum, 1, Integer::sum);

            if (hm.get(datum) > 1) {
                count = hm.get(datum);
            }
        }

        int counter = 0;
        for(Map.Entry<BigDecimal, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == count) {
                if (counter == 0){
                    aveResult.set(0, entry.getKey());
                    counter ++;
                } else {
                    aveResult.add(entry.getKey());
                }
            }
        }

        return aveResult;
    }

    public List<BigDecimal> modeAverage(BigDecimal[] data) {
        int count = 0;
        BigDecimal zero = new BigDecimal("0");
        List<BigDecimal> aveResult = new java.util.ArrayList<>(Collections.singletonList(zero));

        HashMap<BigDecimal, Integer> hm = new HashMap<>();

        for (BigDecimal datum : data) {
            hm.merge(datum, 1, Integer::sum);

            if (hm.get(datum) > 1) {
                count = hm.get(datum);
            }
        }

        int counter = 0;
        for(Map.Entry<BigDecimal, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == count) {
                if (counter == 0){
                    aveResult.set(0, entry.getKey());
                    counter ++;
                } else {
                    aveResult.add(entry.getKey());
                }
            }
        }

        return aveResult;
    }

    // Median Averages

    public BigDecimal medianAverageSortedData(BigDecimal[] data) {
        BigDecimal result;

        if((data.length % 2)==0) {
            int high_index = data.length / 2;
            int low_index = high_index - 1;

            BigDecimal two = new BigDecimal("2");
            result = (data[high_index].divide(data[low_index], 3, RoundingMode.HALF_UP)).multiply(two);
        } else {
            result = data[((data.length - 1) / 2)];
        }

        return result;
    }

    public BigDecimal medianAverageSortedData(List<BigDecimal> data) {
        BigDecimal result;

        if((data.size() % 2)==0) {
            int high_index = data.size() / 2;
            int low_index = high_index - 1;

            BigDecimal two = new BigDecimal("2");
            result = (data.get(high_index).divide(data.get(low_index), 3, RoundingMode.HALF_UP)).multiply(two);
        } else {
            result = data.get(((data.size() - 1) / 2));
        }

        return result;
    }

    public BigDecimal medianAverageUnSortedData(BigDecimal[] data) {
        BigDecimal result;

        BigDecimal[] sortedData = QuickSort.quickSort(data, 0, data.length -1);

        if((data.length % 2)==0) {
            int high_index = data.length / 2;
            int low_index = high_index - 1;

            BigDecimal two = new BigDecimal("2");
            result = (sortedData[high_index].divide(sortedData[low_index], 3, RoundingMode.HALF_UP)).multiply(two);
        } else {
            result = sortedData[((sortedData.length - 1) / 2)];
        }

        return result;
    }

    public BigDecimal medianAverageUnSortedData(List<BigDecimal> data) {
        BigDecimal result;

        List<BigDecimal> sortedData = QuickSort.quickSort(data, 0, data.size() -1);

        if((sortedData.size() % 2)==0) {
            int high_index = sortedData.size() / 2;
            int low_index = high_index - 1;

            BigDecimal two = new BigDecimal("2");
            result = (sortedData.get(high_index).divide(sortedData.get(low_index), 3, RoundingMode.HALF_UP)).multiply(two);
        } else {
            result = sortedData.get(((data.size() - 1) / 2));
        }

        return result;
    }

    public BigDecimal standardDeviation(BigDecimal[] data) {
        BigDecimal mean = meanAverage(data);
        ArrayList<BigDecimal> dataSquared = new ArrayList<>();

        for( BigDecimal datum: data) {
            dataSquared.add((datum.subtract(mean)).multiply(datum));
        }

        BigDecimal meanSquared = meanAverage(dataSquared);
        MathContext mc = new MathContext(4);

        return meanSquared.sqrt(mc);
    }

    public BigDecimal standardDeviation(List<BigDecimal> data) {
        BigDecimal mean = meanAverage(data);
        ArrayList<BigDecimal> dataSquared = new ArrayList<>();

        for( BigDecimal datum: data) {
            dataSquared.add((datum.subtract(mean)).multiply(datum));
        }

        BigDecimal meanSquared = meanAverage(dataSquared);
        MathContext mc = new MathContext(4);

        return meanSquared.sqrt(mc);
    }


}
