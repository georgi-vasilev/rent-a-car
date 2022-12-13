package com.group.carrentalserver.dto;

import com.group.carrentalserver.domain.entity.Location;
import com.group.carrentalserver.domain.entity.Reservation;
import com.group.carrentalserver.domain.entity.Tenant;
import com.group.carrentalserver.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

public class TenantDto {
    private List<Reservation> reservations = new ArrayList<>();
    private  Boolean hasValidLicense;



}
