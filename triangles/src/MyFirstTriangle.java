/**
 * Created by jonathan on 10/04/2017.
 */
public class MyFirstTriangle {
    public static void main(String[]  args) {
        printHorizontalLine(8);
        printVerticalLine(3);
        printTriangle(3);
    }

    private static void printHorizontalLine(int number) {
        int x = number;
        while (x > 0) {
            System.out.print("*");
            x -= 1;
        }
        System.out.print("\n");

    }

    private static void printVerticalLine(int number) {
        int x = number;
        while (x > 0) {
            System.out.println("*");
            x -= 1;
        }
    }

    private static void printTriangle(int number) {
        for(int i = 0; i < number; i++) {
            printHorizontalLine(i+1);
        }
    }


}
