package com.group.carrentalserver.dto;

import com.group.carrentalserver.domain.entity.Equipment;
import com.group.carrentalserver.domain.enumeration.Body;
import com.group.carrentalserver.domain.enumeration.Fuel;
import com.group.carrentalserver.domain.enumeration.Transmission;
import com.group.carrentalserver.domain.enumeration.VehicleStatus;

public class CarDto {
    private String brand;
    private String model;
    private Fuel fuel;
    private Body body;
    private Transmission transmission;
    private VehicleStatus vehicleStatus;
    private Equipment equipment;

}
