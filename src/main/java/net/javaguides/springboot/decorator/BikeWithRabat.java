package net.javaguides.springboot.decorator;

import net.javaguides.springboot.model.Bike;

public class BikeWithRabat extends BikeDecorator {
    public BikeWithRabat(Bike bike) {
        super(bike);
    }

    @Override
    public void dodaj() {
        super.dodaj();
        int priceBike = (int) (bike.getPrice()*0.9);
        bike.setPrice(priceBike);
    }
}
