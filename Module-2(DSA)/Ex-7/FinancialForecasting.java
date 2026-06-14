
public class FinancialForecasting {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }

        double valueAfterOneYear = presentValue * (1 + growthRate);
        return calculateFutureValue(valueAfterOneYear, growthRate, years - 1);
    }

    private static java.util.HashMap<Integer, Double> memo = new java.util.HashMap<>();

    public static double calculateFutureValueMemo(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }

        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        double result = calculateFutureValueMemo(presentValue * (1 + growthRate), growthRate, years - 1);
        memo.put(years, result);
        return result;
    }
}
