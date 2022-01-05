import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TestStreamBasics {
    /*
    Use case 2.1: Create a stream and show each element of the stream
     */
    public Stream<Integer> createIterateStream(){
        ArrayList<Integer> arr_int = new ArrayList<>();
        arr_int.add(1);
        arr_int.add(3);
        arr_int.add((7));
        Stream<Integer> stre_int = arr_int.stream();
        stre_int.forEach( a -> System.out.println(a));
        return stre_int;
    }
    /*
    Use case 2.2: Transform each element to double and store the result
     */
    public Stream<Double> transDoubleStore(){
        ArrayList<Integer> arr_int = new ArrayList<>();
        arr_int.add(1);
        arr_int.add(3);
        arr_int.add((7));
        Stream<Integer> stre_int = arr_int.stream();
        Stream<Double> strm_doub = stre_int.map( num -> Double.valueOf(num));
        return strm_doub;
    }
    /*
    Use Case 2.3: Store transformed double value into a list
     */
    public void transDoubleList(){
        Stream<Double> strm_doub = transDoubleStore();
        List<Double> list_doub = strm_doub.collect(toList());
        list_doub.forEach(num -> System.out.println(num));
    }
    public static void main(String[] args) {
        TestStreamBasics testbasic = new TestStreamBasics();
        testbasic.transDoubleList();
    }
}
