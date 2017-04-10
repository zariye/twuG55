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
        System.out.println("Print iso triangle");
        printIsoTriangle(3);
        System.out.println("Print diamond");
        printDiamond(4);
        System.out.println("Print name diamond");
        printDiamondName(4, "Zara");
        System.out.println("Print fizzbuzz");
        printFizzBuzz();

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

    private static void printDiamond(int lines) {
        int l = lines;
        int count = 1;

        while(l > 0) {
            printHorizontalLine(l - 1, count);
            l--;
            count += 2;
        }
        count -= 2;
        while(l < lines - 1) {
            l++;
            count -= 2;
            printHorizontalLine(l, count);
        }
    }

    private static void printDiamondName(int lines, String name) {
        int l = lines;
        int count = 1;

        while(l > 1) {
            printHorizontalLine(l - 1, count);
            l--;
            count += 2;
        }

        System.out.println(name);

        l = 0;
        while(l < lines - 1) {
            l++;
            count -= 2;
            printHorizontalLine(l, count);
        }
    }

    private static void printFizzBuzz() {
      String fizzBuzz;

      for (int i = 1; i <= 100; i++) {
        fizzBuzz = "";

        if ((i % 3) == 0) {
          fizzBuzz ="Fizz";
        }

        if ((i % 5) == 0) {
          fizzBuzz += "Buzz";
        }

        if (fizzBuzz.isEmpty()) {
          System.out.println(i);
        } else {
          System.out.println(fizzBuzz);
        }
      }
    }
}
