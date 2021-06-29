package com.example.myapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/*Usando os beans em uma classe de exemplo e não diretamente no main*/

@Service
public class VehicleTestService {

    @Autowired
    //@Qualifier("planeVehicleServiceConfiguration")
    VehicleService vehicleService;

    public void testVehicle(){
        vehicleService.startEngine();
        vehicleService.move();
        vehicleService.stopEngine();
    }
}
