/**
 * Created by jonathan on 10/04/2017.
 */
public class MyFirstTriangle {
    public static void main(String[]  args) {
        System.out.println("Print horizontal line");
        printHorizontalLine(0, 8);
        System.out.println("Print vertical line");
        printVerticalLine(3);
        System.out.println("Print triangle line");
        printTriangle(3);
        System.out.println("Print iso triangle line");
        printIsoTriangle(3);
    }

    private static void printHorizontalLine(int spaces, int number) {
        int x = number;

        System.out.print(getSpaces(spaces));

        while (x > 0) {
            System.out.print("*");
            x -= 1;
        }
        System.out.print("\n");
    }


    private static String getSpaces(int count) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < count; i++) {
            sb.append(" ");
        }

        return sb.toString();
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
            printHorizontalLine(0, i+1);
        }
    }

    private static void printIsoTriangle(int lines) {
        int l = lines;
        int count = 1;

        while(l > 0) {
            printHorizontalLine(l - 1, count);
            l--;
            count += 2;
        }
    }


}
