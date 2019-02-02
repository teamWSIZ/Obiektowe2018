package wsi.exec.model;

import wsi.exec.model.bees.Bee;

import java.util.List;

//Miejsca w których mogą przebywać pszczoły
public interface Place {

    List<Bee> getBees();    //wszystkie pszczoły obecne w tej lokacji

    List<Place> getNearbyPlaces(); //wszystkie miejsca do których można dojść z tego miejsca (bezpośrednio)

    void addBee(Bee b);  //pszczoła wlatuje do tego miejsca

    void removeBee(Bee b);  //pszczoła wylatuje z tego miejsca



    //metody do konstrukcji świata
    void addNearbyPlace(Place other);  //dodaje dodatkowe miejsce osiągalne z obecnego

    void beesFeed();

    void beesCommunicate();

    void beesBreed();

    void beesMove();

    void print();
}