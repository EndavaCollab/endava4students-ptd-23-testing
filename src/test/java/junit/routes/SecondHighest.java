package junit.routes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecondHighest {

    public static void main(String[] args) {
        //array: {100,14,46,47,94,94,100,52,86,36,94,89}  -- >  94

        int[] array = {100, 14, 46, 47, 94, 94, 100, 52, 86, 36, 94, 89};

        List<Integer> list = Arrays.stream(array).distinct().sorted().collect(Collectors.toList());
        //List<Integer> list = new ArrayList<>(array);
        //list.stream().distinct().sorted().collect(Collectors.toList())

    }

    public static int returnMax(IntStream stream) {
        int max = -1;

        int[] array = stream.toArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
}

