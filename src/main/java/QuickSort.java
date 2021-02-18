import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public abstract class QuickSort {

    public static BigDecimal[] quickSort(BigDecimal[] arr, int low, int high) {

        if (arr.length == 0)
            return arr;

        if (low >= high)
            return arr;

        int left = low + 1;
        int right = high;
        BigDecimal pivotValue = arr[low];

        while (left <= right) {
            while( left <= high && pivotValue.compareTo(arr[left]) >= 0 ) {
                left++;
            }
            while( right > low && pivotValue.compareTo(arr[right]) < 0 ) {
                right--;
            }
            if( left < right ) {
                BigDecimal temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        BigDecimal temp = arr[low];
        arr[low] = arr[left - 1];
        arr[left - 1] = temp;

        quickSort(arr, low, right -1);
        quickSort(arr, right +1, high);

        return arr;
    }

    public static List<BigDecimal> quickSort(List<BigDecimal> arr, int low, int high) {

        if (arr.size() == 0)
            return arr;

        if (low >= high)
            return arr;

        int left = low + 1;
        int right = high;
        BigDecimal pivotValue = arr.get(low);

        while (left <= right) {
            while( left <= high && pivotValue.compareTo(arr.get(left)) >= 0 ) {
                left++;
            }
            while( right > low && pivotValue.compareTo(arr.get(right)) < 0 ) {
                right--;
            }
            if( left < right ) {
                Collections.swap(arr, left, right);
            }
        }

        Collections.swap(arr, low, left -1);
        quickSort(arr, low, right -1);
        quickSort(arr, right +1, high);

        return arr;
    }
}
