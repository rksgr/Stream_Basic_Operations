import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class TestStreamBasics {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,3,4,5);
        List<Integer> square = nums.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println(square);
        ArrayList<Integer> arr_int = new ArrayList<>();
        arr_int.add(2);
        arr_int.add(5);
        System.out.println(arr_int.stream().collect(Collectors.toList()));
    }
}
