package net.javaguides.springboot.adapter;

import net.javaguides.springboot.model.Bike;

public class AdapterImpl implements Price{
    private Bike bik;

    public AdapterImpl(Bike bik) {
        this.bik = bik;
    }

    @Override
    public double getPriceInt(){
        return bik.getPrice()*4.7;
    }

}
