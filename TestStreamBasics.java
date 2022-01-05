import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
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
    /*
    Use case 2.4: Filter the even numbers from the number stream and store the result
     */
    public void filterEvenStore(){
        List<Integer> list_int = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> list_int_filt = list_int.stream().filter(num -> (num%2==0)).collect(toList());
        list_int_filt.forEach(numm -> System.out.println(numm));
    }
    /*
    Use case 2.5: Peek and show first even number in the number stream
     */
    public void peekShowFirstEven(){
        List<Integer> list_int = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Optional<Integer> first_even_num = list_int.stream().filter(num -> num%2==0).peek(System.out::println).findFirst();
    }
    /*
    Use case 2.6: Find min and max number in the number stream
     */
    public void findMaxMin(){
        List<Integer> list_int = Arrays.asList(1,2,3,44,98,4,5,6,7,8,9);
        Optional<Integer> max_num = list_int.stream().max((num1,num2)->num1.compareTo(num2));
        System.out.println("Maximum number in stream: "+ max_num.get());
        Optional<Integer> min_num = list_int.stream().min((num1,num2)->num1.compareTo(num2));
        System.out.println("Minimum number in stream: " + min_num.get());
    }

    public static void main(String[] args) {
        TestStreamBasics testbasic = new TestStreamBasics();
        testbasic.findMaxMin();
    }
}
