
import java.util.*;

public class Knapsackdynamic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] profit = new int[n];

        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter profits of items:");
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        int[][] dp = new int[n + 1][W + 1];

        // Dynamic Programming
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Profit: " + dp[n][W]);

        sc.close();
    }
}
