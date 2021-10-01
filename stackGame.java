package com.company;

import java.util.Scanner;

public class stackGame {

    static int twoStacks(int x, int[] a, int[] b) {

        int a_index = 0;
        int b_index = 0;
        int count = 0;
        int sum = 0;
        while (b_index < b.length && sum + b[b_index] <= x) {
            sum += b[b_index];
            b_index++;
        }

        b_index--;
        count = b_index + 1;

        while (a_index < a.length && b_index < b.length) {
            sum += a[a_index];
            if (sum > x) {
                while (b_index >= 0) {
                    sum -= b[b_index];
                    b_index--;
                    if (sum <= x) break;
                }
                
                if (sum > x && b_index < 0) {
                    a_index--;
                    break;
                }
            }
            count = Math.max(a_index + b_index + 2, count);
            a_index++;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {

            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());
            int m = Integer.parseInt(nmx[1].trim());
            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];
            String[] aItems = scanner.nextLine().split(" ");
            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];
            String[] bItems = scanner.nextLine().split(" ");
            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);
            System.out.println(result);
        }
    }
}
