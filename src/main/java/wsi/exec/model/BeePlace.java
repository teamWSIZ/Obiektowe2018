package wsi.exec.model;

import java.util.List;

//Miejsca w których mogą przebywać pszczoły
public interface BeePlace {

    List<Bee> getBees();    //wszystkie pszczoły obecne w tej lokacji

    Integer getFood();      //całkowita ilość żywności w tej lokacji

    List<BeePlace> nearbyPlaces(); //wszystkie miejsca do których można dojść z tego miejsca (bezpośrednio)

    void beeEnters(Bee b);  //pszczoła wlatuje do tego miejsca

    void beeLeaves(Bee b);  //pszczoła wylatuje z tego miejsca

    void addNearbyPlace(BeePlace other);  //dodaje dodatkowe miejsce osiągalne z obecnego

}
