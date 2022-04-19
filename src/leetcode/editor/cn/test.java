import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(-3, 0, 0, 3));
        result.add(Arrays.asList(-3, 0, 1, 2));
        result.add(Arrays.asList(-3, 0, 1, 2));
        System.out.println(result.toString());
        List<List<Integer>> result0 = result.stream().distinct().collect(Collectors.toList());
        System.out.println(result0.toString());
//        List<List<Integer>> result1 = Stream.of(result).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        Stream.of(result).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        System.out.println(result.toString());
    }
}