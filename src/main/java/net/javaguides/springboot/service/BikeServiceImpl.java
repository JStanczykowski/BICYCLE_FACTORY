package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BikeServiceImpl implements BikeService {
    private final BikeRepository bikeRepository;

    @Autowired
    public BikeServiceImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }
    @Override
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }


    public Bike saveBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    @Override
    public Bike saveBikeBuilder(Bike bike) {
        return bikeRepository.save(bike);
    }

    @Override
    public Bike getBikeById(long id) {
        return bikeRepository.findById(id).get();
    }


    @Override
    public Bike updateBike(Bike  bike) {
        return bikeRepository.save(bike);
    }

    @Override
    public void deleteBikeById(long id) {
        bikeRepository.deleteById(id);
    }

    @Override
    public Bike getBike(long id) {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        return optionalBike.get();
    }
    @Override
    public List<Bike> getListBike(Authentication auth, BikeService bikeService){
        List<Bike> lista = new ArrayList<>();
        for(Bike listBike: bikeService.getAllBikes()) {
            if(listBike.getNumberOwner().equals(auth.getName())){

                lista.add(listBike);
            }
        }
        return lista;
    }
}
