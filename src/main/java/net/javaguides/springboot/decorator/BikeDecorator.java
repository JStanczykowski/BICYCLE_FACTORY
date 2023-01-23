package net.javaguides.springboot.decorator;

import net.javaguides.springboot.model.Bike;

public abstract class BikeDecorator implements BikeInterface {
    protected Bike bike;

    public BikeDecorator(Bike bike) {
        this.bike = bike;
    }

    @Override
    public void dodaj() {
        this.bike.dodaj();
    }
}
