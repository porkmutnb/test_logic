import java.util.Scanner;

public class LoopPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Integer: ");
        int loop = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.print("Enter Type to print [(L left, R right, C center) default=>L]: ");
        String type = sc.nextLine();
        type = type != null && !type.equals("") ? type.toUpperCase() : "L";
        String symbol = "*";
        processLoopPrint(symbol, type, loop);
    }

    private static void processLoopPrint(String symbol, String type, int loop) {
        switch (type) {
            case "L":
                for (int i = 1; i <= loop; i++) {
                    System.out.println("*".repeat(i));
                }
                break;
            case "R":
                for (int i = 1; i <= loop; i++) {
                    System.out.println(" ".repeat(loop - i) + symbol.repeat(i));
                }
                break;
            case "C":
                int newLoop = (loop / 2) + Math.round(loop % 2);
                int index = 1;
                for (int i = 1; i <= newLoop; i++) {
                    System.out.println(" ".repeat(newLoop - i) + symbol.repeat(index));
                    index += 2;
                }
                break;
            default:
                System.out.println("Error: type to print incorrect, type=>" + type);
                break;
        }
    }
}
