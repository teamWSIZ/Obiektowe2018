package wsi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

    static void listy() {
        List<Integer> lista = new ArrayList<>();
        lista.add(11);
        lista.add(5);
        System.out.println(lista);
    }


    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(15);
        set.add(18);
        set.add(15);
        set.add(18);
        set.add(15);
        set.add(18);
        set.add(-1);
        System.out.println(set);




    }
}
