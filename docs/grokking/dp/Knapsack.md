# 01 Knapsack - Medium

Given the weights and profits of ```N``` items, we are asked to put these items in a knapsack which has a capacity ```C```. 

The goal is to get the maximum profit out of the items in the knapsack. 
Each item can only be selected once, as we don’t have multiple quantities of any item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. 
    Here are the weights and profits of the fruits:

```
Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5
```

Let’s try to put various combinations of fruits in the knapsack, such that their total weight is not more than 5:
- Apple + Orange (total weight 5) => 9 profit
- Apple + Banana (total weight 3) => 7 profit
- Orange + Banana (total weight 4) => 8 profit
- Banana + Melon (total weight 5) => 10 profit

This shows that ```Banana + Melon``` is the best combination as it gives us <b>the maximum profit</b> and the total weight does not exceed the capacity.


#### Java Solution

```java
public class Knapsack {

    static int knapsack(int w, int wt[], int val[], int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (wt[n - 1] > w) {
            return knapsack(w, wt, val, n - 1);
        }
        int preWeight = knapsack(w, wt, val, n -1);
        return Math.max(val[n - 1] + knapsack(w - wt[n - 1], wt, val, n - 1), preWeight);
    }

    static int knapsackDp(int w, int wt[], int val[], int n) {
        int k[][] = new int[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    k[i][j] = Math.max(k[i - 1][j], k[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }
        return k[n][w];
    }

    static int knapsackDpSimple(int w, int wt[], int val[], int n) {
        int k[] = new int[w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = w; j >= wt[i]; --j) {
                k[j] = Math.max(k[j], k[j - wt[i]] + val[i]);
            }
        }
        return k[w];
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/dp/Knapsack.java)