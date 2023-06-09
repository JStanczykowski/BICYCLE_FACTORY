package net.javaguides.springboot.bike;

import net.javaguides.springboot.adapter.AdapterImpl;
import net.javaguides.springboot.adapter.Price;
import net.javaguides.springboot.decorator.BikeInterface;
import net.javaguides.springboot.decorator.BikeWithFS;
import net.javaguides.springboot.decorator.BikeWithRabat;
import net.javaguides.springboot.model.Bike;
import net.javaguides.springboot.model.Orders;
import net.javaguides.springboot.repository.BikeRepository;
import net.javaguides.springboot.repository.OrdersRepository;
import net.javaguides.springboot.service.BikeService;
import net.javaguides.springboot.service.BikeServiceImpl;
import net.javaguides.springboot.service.OrdersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
public class BikeTest {
    @Autowired
    public BikeRepository bikeRepository;
    @Autowired
    public BikeServiceImpl bikeServiceImpl;

    @Autowired
    public BikeService bikeService;

    @Autowired
    public OrdersService ordersService;

    @Autowired
    public OrdersRepository ordersRepository;

    @BeforeEach
    void setup() {
        bikeRepository = mock(BikeRepository.class);
        bikeServiceImpl = new BikeServiceImpl(bikeRepository);
    }

    @Test
    void addBike() {
        LocalDate localDate = LocalDate.now();
        Orders orders = new Orders("blabla", localDate);
        Bike bike = new Bike.BikeEntityBuilder().
                setSerialNumber(6).
                setBikeType("type").
                setSize("size").
                setColor("color").
                build();
        ordersService.saveOrder(orders);
        bikeServiceImpl.saveBikeBuilder(bike);

        List<Bike> all = bikeRepository.findAll();

        assertThat(all.contains(bike));
    }

    @Test
    void removeBike() {
        LocalDate localDate = LocalDate.now();
        Orders orders = new Orders("blabla", localDate);
        Bike bike = new Bike.
                BikeEntityBuilder().
                setSerialNumber(5).
                setBikeType("type").
                setSize("size").
                setColor("color").
                setOrder(orders).
                build();
        ordersService.saveOrder(orders);
        bikeServiceImpl.deleteBikeById(1);

        List<Bike> all = bikeRepository.findAll();

        assertThat(all.contains(bike));
    }

    @Test
    void addBikeWithBlotnik() {
        LocalDate localDate = LocalDate.now();
        Orders orders = new Orders("blabla", localDate);
        Bike bike = new Bike.BikeEntityBuilder().
                setSerialNumber(5).
                setBikeType("type").
                setSize("size").
                setColor("color").
                build();
        BikeInterface bikeInterface = new BikeWithFS(bike);

        bikeInterface.dodaj();
        ordersService.saveOrder(orders);
        bikeServiceImpl.saveBikeBuilder(bike);

        List<Bike> all = bikeRepository.findAll();

        assertThat(all.contains(bike));
    }
    @Test
    void addBikeWithRabat() {
        LocalDate localDate = LocalDate.now();
        Orders orders = new Orders("blabla", localDate);
        Bike bike = new Bike.BikeEntityBuilder().
                setSerialNumber(5).
                setBikeType("type").
                setSize("size").
                setColor("color").
                setPrice(1000).
                build();
        BikeInterface bikeInterface = new BikeWithRabat(bike);

        bikeInterface.dodaj();
        ordersService.saveOrder(orders);
        bikeServiceImpl.saveBikeBuilder(bike);

        List<Bike> all = bikeRepository.findAll();

        assertThat(all.contains(bike));
    }

    @Test
    void adapter(){
        Bike bike = new Bike.BikeEntityBuilder().
                setSerialNumber(5).
                setBikeType("type").
                setSize("size").
                setColor("color").
                setPrice(1000).
                build();
        Price euro = new AdapterImpl(bike);
        System.out.println(euro);
    }
}
