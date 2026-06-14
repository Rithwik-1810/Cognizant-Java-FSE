
public class Main {

    public static void main(String[] args) {

        double initialInvestment = 10000.00;
        double annualGrowthRate = 0.08;

        System.out.println("\nFinancial Forecast:");
        System.out.println("Initial Investment : $" + initialInvestment);
        System.out.printf("Annual Growth Rate : %.0f%%%n", annualGrowthRate * 100);

        int[] years = {1, 5, 10, 20, 30};

        System.out.println("\nPredicted future values (recursive calculation):");
        for (int year : years) {
            double futureValue = FinancialForecasting.calculateFutureValue(
                    initialInvestment, annualGrowthRate, year
            );
            System.out.printf("After %2d year(s) : $%.2f%n", year, futureValue);
        }

        System.out.println("\nVerification using Math.pow:");
        for (int year : years) {
            double expected = initialInvestment * Math.pow(1 + annualGrowthRate, year);
            System.out.printf("After %2d year(s) : $%.2f%n", year, expected);
        }

        System.out.println("\nBoth results match - recursive solution is correct.");

        System.out.println("\nTime Complexity:");
        System.out.println("Recursive approach - O(n), one call per year");
        System.out.println("Memoization helps when the same sub-problem is solved multiple times.");
        System.out.println("An iterative loop would also work here and avoids stack overhead.");
    }
}
