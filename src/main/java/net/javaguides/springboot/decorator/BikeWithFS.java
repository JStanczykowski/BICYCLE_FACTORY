package net.javaguides.springboot.decorator;

import net.javaguides.springboot.model.Bike;

public class BikeWithFS extends BikeDecorator {
    public BikeWithFS(Bike bike) {
        super(bike);
    }
    @Override
    public void dodaj() {
        super.dodaj();
        if(bike.getAddextend().equals("Rama wzmocniona FS 29''"))
            bike.setPrice(bike.getPrice());
        else if(bike.getAddextend().equals("Rama wzmocniona HT 29''"))
            bike.setPrice(bike.getPrice() + 50.00);
        else
            bike.setPrice(bike.getPrice() + 150.00);

        bike.setAddextend("Rama wzmocniona FS 29''");


    }
}
