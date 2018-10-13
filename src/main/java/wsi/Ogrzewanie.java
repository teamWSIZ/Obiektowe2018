package wsi;



// {0,0,1,0,0,0,1,0,0,0,1} r=2 ---> true
// {0,0,1,0,0,0} r=2 ---> false
// {0,0,1,0,0,0,0,0,0,0,0,0,0,0} r=20 ---> true

import java.util.Arrays;

public class Ogrzewanie {

    boolean isHeated(int[] heaters, int r) {
        ///podzadanie 1: storzyć listę pozycji, na których
        /// tablica "heaters" ma "1"
        for (int poz = 0; poz < heaters.length; poz++) {

        }
        return true;
    }


    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = 4;
        }
        System.out.println(Arrays.toString(a));

    }

}
