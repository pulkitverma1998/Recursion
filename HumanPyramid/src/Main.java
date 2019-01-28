// Pulkit Verma
// Class (CECS 274-05)
// Project Name (Program 4 - Human Pyramid)
// Due Date (Oct 30, 2018)

import java.util.Scanner;

public class Main {

    static int count = 0;

    // This method calculates the total weight supported by a person at a given row and column
    public static double calculate_total_weight(int r, int c, int weight) {

        count++;

        if (r == 1 && c == 1) {
            return 0;
        } else if (c == 1) {
            return (calculate_total_weight(r - 1, c, weight) + weight) / 2;
        } else if (c == r) {
            return (calculate_total_weight(r - 1, c - 1, weight) + weight) / 2;
        } else if (r > c) {
            return weight + (calculate_total_weight(r - 1, c - 1, weight) / 2) + (calculate_total_weight(r - 1, c, weight) / 2);
        }
        return 0;
    }

    public static void main(String[] args) {

        int row;
        int column;
        int WEIGHT_OF_PERSON = 200;

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Human Pyramid. Select a row, column combination and I will tell you how much weight that person is supporting.\n");

        System.out.println("Please type your selections for Row and Column:");

        row = input.nextInt();
        column = input.nextInt();

        while (row != 0 && column != 0) {
            count = 0;
            double total_weight = calculate_total_weight(row, column, WEIGHT_OF_PERSON);

            System.out.printf("Person at (%d,%d) is supporting %.1f pounds.\n", row, column, total_weight);

            if (row == 1 && column == 1) {
                System.out.printf("(The recursive function was called %d time)\n\n", count);
            } else {
                System.out.printf("(The recursive function was called %d times)\n\n", count);
            }

            System.out.println("Please type your selections for Row and Column:");

            row = input.nextInt();
            column = input.nextInt();
        }

        System.out.print("Thanks for playing Human Pyramid. Don't let me down!");
    }
}
