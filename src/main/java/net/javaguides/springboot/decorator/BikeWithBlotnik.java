package net.javaguides.springboot.decorator;

import net.javaguides.springboot.model.Bike;

public class BikeWithBlotnik extends BikeDecorator {
    public BikeWithBlotnik(Bike bike) {
        super(bike);
    }
    @Override
    public void dodaj() {
        super.dodaj();
        bike.setAddextend("Blotnik");
    }
}
