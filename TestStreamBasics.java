import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
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
    /*
    Use case 2.7: Find sum and average of the number stream
     */
    public void findSumAverage(){
        List<Integer> list_int = Arrays.asList(12,19,34,55,32,41,21,81,202,100);
        // find number of elements in the stream
        long cnt_nums = list_int.stream().count();
        // find sum of all the elements of the stream
        int sum_nums = list_int.stream().reduce(0,(num1,num2)->(num1+num2));
        System.out.println("Sum of numbers in stream: "+sum_nums);
        System.out.println("Average of numbers in stream: "+sum_nums/cnt_nums);
    }
    /*
    Use case 2.8: find all the number or at least one number is even in the number stream
     */
    public void findAllOrAtLeastOneEven(){
        List<Integer> list_int = Arrays.asList(1,3,5,7,10);
        boolean all_even = list_int.stream().allMatch(num -> num%2==0);
        System.out.println("All numbers in stream even: "+ all_even);
        boolean at_least_one_even = list_int.stream().anyMatch(num->num%2==0);
        System.out.println("At least one number in stream even: " + at_least_one_even);
        boolean none_even = list_int.stream().noneMatch(num->num%2==0);
        System.out.println("No number in the stream is even: "+ none_even);
    }
    /*
    Use case 2.9: Sort number stream in ascending order
     */
    public void sortAscending(){
        List<Integer> list_int = Arrays.asList(12,5,9,67,45,21,7,25);
        List<Integer> list_sort_int = list_int.stream().sorted().collect(toList());
        System.out.println((list_sort_int));
    }
    public static void main(String[] args) {
        TestStreamBasics testbasic = new TestStreamBasics();
        testbasic.sortAscending();
    }
}
