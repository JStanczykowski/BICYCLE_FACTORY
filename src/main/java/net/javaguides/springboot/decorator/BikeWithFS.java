package net.javaguides.springboot.decorator;

import net.javaguides.springboot.model.Bike;

public class BikeWithFS extends BikeDecorator {
    public BikeWithFS(Bike bike) {
        super(bike);
    }
    @Override
    public void dodaj() {
        super.dodaj();

        bike.setAddextend("Rama wzmocniona FS 29''");
    }
}
