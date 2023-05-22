package com.algorithm.contest.weeklycontest295;

public class DiscountPrices {

    public static void main(String[] args) {

        String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        System.out.println(discountPrices(sentence, discount));

        String sentence1 = "1 2 $3 4 $5 $6 7 8$ $9 $10$";
        int discount1 = 100;
        System.out.println(discountPrices(sentence1, discount1));

        String sentence2 = "ka3caz4837h6ada4 r1 $602";
        int discount2 = 9;
        System.out.println(discountPrices(sentence2, discount2));

        String sentence3 = "706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6";
        int discount3 = 28;
        System.out.println(discountPrices(sentence3, discount3));

        String sentence4 = "$2$3 $10 $100 $1 200 $33 33$ $$ $99 $99999 $9999999999";
        int discount4 = 0;
        System.out.println(discountPrices(sentence4, discount4));
    }

    public static String discountPrices(String sentence, int discount) {
        char[] chrs = sentence.toCharArray();
        int n = chrs.length;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        double disc = (100 - discount) / 100.00;
        while (i < n) {
            if (chrs[i] != '$' || (i > 0 && chrs[i - 1] != ' ')) {
                sb.append(chrs[i]);
                i++;
                continue;
            }
            sb.append(chrs[i++]);
            if (i < n && Character.isDigit(chrs[i])) {
                int k = 1;
                boolean isPrice = false;
                long num = (chrs[i] - '0');
                while (k < 11) {
                    int ind = k + i;
                    if (ind < n && Character.isDigit(chrs[ind])) {
                        num = 10 * num + (chrs[ind] - '0');
                        k++;
                        continue;
                    }
                    if (ind == n || chrs[ind] == ' ') {
                        isPrice = true;
                    }
                    break;
                }
                if (isPrice) {
                    double price = num * disc;
                    sb.append(String.format("%.2f", price));
                } else {
                    for (int j = 0; j < k; j++) {
                        sb.append(chrs[i + j]);
                    }
                }
                i = i + k;
            }
        }

        return sb.toString();
    }
}
