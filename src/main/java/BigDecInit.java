import java.math.BigDecimal;
import java.util.ArrayList;


public abstract class BigDecInit {

    public BigDecInit(){

    }

    public BigDecimal convertToBigDecimal(Double num) {
        return new BigDecimal(num.toString());
    }

    public ArrayList<BigDecimal> convertToBigDecimal(Double[] num) {
        ArrayList<BigDecimal> result = new ArrayList<>();
        for (Double datum: num){
            result.add(convertToBigDecimal(datum));
        }
        return result;
    }

    public ArrayList<BigDecimal> convertToBigDecimal(ArrayList<Double> num) {
        ArrayList<BigDecimal> result = new ArrayList<>();
        for (Double datum: num){
            result.add(convertToBigDecimal(datum));
        }
        return result;
    }
}
