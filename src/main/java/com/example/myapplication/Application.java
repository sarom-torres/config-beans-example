package com.example.myapplication;

import com.example.myapplication.service.CarVehicleService;
import com.example.myapplication.service.VehicleService;
import com.example.myapplication.service.VehicleTestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class,args);
//        VehicleService vehicleService = context.getBean(VehicleService.class);
//        //VehicleService vehicleService = context.getBean(CarVehicleService.class);
//        vehicleService.startEngine();
//        vehicleService.move();
//        vehicleService.stopEngine();
        VehicleTestService vehicleTestService = context.getBean(VehicleTestService.class);
        vehicleTestService.testVehicle();
    }
}
