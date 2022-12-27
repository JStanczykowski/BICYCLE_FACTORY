package net.javaguides.springboot.bike;

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
        Bike bike = new Bike("dsaa", "dsada", "dasda ", "das",true);
        ordersService.saveOrder(orders);
        bikeServiceImpl.saveBike(bike);

        List<Bike> all = bikeRepository.findAll();

        assertThat(all.contains(bike));
    }

    @Test
    void removeBike() {
        LocalDate localDate = LocalDate.now();
        Orders orders = new Orders("blabla", localDate);
        Bike bike = new Bike("dsaa", "dsada", "dasda ", "das",true);
        ordersService.saveOrder(orders);
        bikeServiceImpl.deleteBikeById(1);

        List<Bike> all = bikeRepository.findAll();

        assertThat(all.contains(bike));
    }
}
