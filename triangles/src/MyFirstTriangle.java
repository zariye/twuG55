/**
 * Created by jonathan on 10/04/2017.
 */
public class MyFirstTriangle {
    public static void main(String[]  args) {
        printHorizontalLine (8);
    }

    static void printHorizontalLine(int number) {
        int x = number;
        while (x > 0) {
            System.out.print("*");
            x -= 1;
        }
    }
}
