package net.javaguides.springboot.decorator;

import net.javaguides.springboot.model.Bike;

public class BikeWithHT extends BikeDecorator{
    public BikeWithHT(Bike bike) {
        super(bike);
    }
    @Override
    public void dodaj() {
        super.dodaj();
        bike.setAddextend("Rama wzmocniona HT 29''");
    }
}
