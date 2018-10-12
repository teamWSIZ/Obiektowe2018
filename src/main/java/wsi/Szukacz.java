package wsi;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Szukacz {
    boolean doesContain(int[] arr, int x) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        if(list.contains(x)) {
            return true;
        }else {
            return false;
        }
    }
}
