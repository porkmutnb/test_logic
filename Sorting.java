import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter any key ...");
        if (sc.nextLine().equals("")) {
            List<Integer> originalList = new ArrayList<>();
            originalList.add(5);
            originalList.add(2);
            originalList.add(4);
            originalList.add(1);
            originalList.add(3);
            System.out.println("originalList: " + originalList.toString());
            System.out.println("targetList ASC: " + sortAsc(originalList));
            System.out.println("targetList DESC: " + sortDesc(originalList));
        } else {
            customLogic(sc);
        }
    }

    public static void customLogic(Scanner sc) {
        List<Integer> originalList = new ArrayList<>();
        String line = null;
        do {
            if (originalList.isEmpty()) {
                System.out.print("Enter input number: ");
                line = sc.nextLine();
            } else {
                System.out.print("Enter input number [Enter for skip]: ");
                line = sc.nextLine();
            }
            try {
                if (!line.equals("")) {
                    Integer number = Integer.parseInt(line);
                    originalList.add(number);
                }
            } catch (Exception e) {
            }
        } while (line == null || !line.equals(""));
        String action = "";
        do {
            System.out.print("You choose sort method [Asc or Desc / A or D / a or d]: ");
            action = sc.nextLine();

            action = action.equals("") && !action.substring(0).toUpperCase().equals("A")
                    && !action.substring(0).toUpperCase().equals("D") ? "" : action;
        } while (action.equals(""));
        System.out.println("originalList: " + originalList.toString());
        System.out.println("   Sort by " + action);
        if (action.substring(0).toUpperCase().equals("A")) {
            System.out.println("targetList: " + sortAsc(originalList).toString());
        } else {
            System.out.println("targetList: " + sortDesc(originalList).toString());
        }
    }

    public static List<Integer> sortAsc(List<Integer> originalList) {
        List<Integer> targetList = new ArrayList<>();
        do {
            targetList = new ArrayList<>();
            Integer min = null;
            for (Integer item1 : originalList) {
                min = min == null ? item1 : min < item1 ? item1 : min;
                for (Integer item2 : originalList) {
                    if (item1 > item2 && !targetList.contains(item2)) {
                        targetList.add(item2);
                    }
                }
            }
            targetList.add(min);
        } while (isAsc(targetList));
        return targetList;
    }

    public static Boolean isAsc(List<Integer> originalList) {
        Integer min = null;
        for (Integer item1 : originalList) {
            min = min == null ? item1 : min < item1 ? item1 : min;
        }
        return min == null ? false : originalList.get(0) == min;
    }

    public static List<Integer> sortDesc(List<Integer> originalList) {
        List<Integer> targetList = new ArrayList<>();
        do {
            Integer max = null;
            for (Integer item1 : originalList) {
                max = max == null ? item1 : max > item1 ? item1 : max;
                for (Integer item2 : originalList) {
                    if (item1 < item2 && !targetList.contains(item2)) {
                        targetList.add(item2);
                    }
                }
            }
            targetList.add(max);
        } while (isDesc(targetList));
        return targetList;
    }

    public static Boolean isDesc(List<Integer> originalList) {
        Integer max = null;
        for (Integer item1 : originalList) {
            max = max == null ? item1 : max > item1 ? item1 : max;
        }
        return max == null ? false : originalList.get(0) == max;
    }
}
