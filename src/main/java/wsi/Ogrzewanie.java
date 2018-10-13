package wsi;



// {0,0,1,0,0,0,1,0,0,0,1} r=2 ---> true
// {0,0,1,0,0,0} r=2 ---> false
// {0,0,1,0,0,0,0,0,0,0,0,0,0,0} r=20 ---> true

import java.util.*;

public class Ogrzewanie {

    boolean isHeated(int[] heaters, int r) {
        ///podzadanie 1: storzyć listę pozycji, na których
        /// tablica "heaters" ma "1"
        List<Integer> grzejniki = new ArrayList<>();
        for (int poz = 0; poz < heaters.length; poz++) {
            if (heaters[poz]==1) {
                grzejniki.add(poz);
            }
        }

        System.out.println(grzejniki);
        Set<Integer> ogrzane = new HashSet<>();

        for(int g : grzejniki) {
            for (int i = 0; i <= r; i++) {
                ogrzane.add(g + i);
                ogrzane.add(g - i);
            }
        }
        System.out.println(ogrzane);

        for (int i = 0; i < heaters.length; i++) {
            if (!ogrzane.contains(i)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
//        int[] a = new int[10];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = 4;
//        }
//        System.out.println(Arrays.toString(a));
        int[] dane = new int[]{0,0,1,0,1};

        Ogrzewanie instancja = new Ogrzewanie();
        instancja.isHeated(dane, 10);


    }

}
