package junit.tests;

public class Problem {

    // integer array sorted . can contain duplicates. find the greatest number 10 20 25 35 40 -- >
    // 10 20 20 25 25 35 40  -- > no 6th greatest number

    public static void main(String[] args) {
        int[] array = {10, 20, 20, 25, 25, 35, 40};
        System.out.println(findXGreatestNumber(array, 1));
    }

    public static int findXGreatestNumber(int[] numbers, int xGreatest) {
        int[] descArray = new int[numbers.length];
        int[] removedDuplicatesArray = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == numbers[i + 1]) {
                removedDuplicatesArray[i] = numbers[i];
                i = i + 2;
            }
        }

        for (int i = 0; i < removedDuplicatesArray.length; i++) {
            descArray[i] = returnMax(removedDuplicatesArray);
        }

        return descArray[xGreatest];
    }

    public static int returnMax(int[] myArray) {
        int found = -1;
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] > found) {
                found = myArray[i];
            }
        }
        return found;
    }
}
