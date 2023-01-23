package net.javaguides.springboot.decorator;

import net.javaguides.springboot.model.Bike;

public class BikeWithHT extends BikeDecorator{
    public BikeWithHT(Bike bike) {
        super(bike);
    }
    @Override
    public void dodaj() {
        super.dodaj();
        if(bike.getAddextend().equals("Rama wzmocniona FS 29''"))
            bike.setPrice(bike.getPrice()-50.00);
       else  if(bike.getAddextend().equals("Rama wzmocniona HT 29''"))
            bike.setPrice(bike.getPrice());
      else
            bike.setPrice(bike.getPrice()+100);


        bike.setAddextend("Rama wzmocniona HT 29''");



    }
}
