package org.avi1606.uberprojectlocationsevices.services;

import org.avi1606.uberprojectlocationsevices.dto.DriverLocationDTO;

import java.util.List;

public interface LocationService {
    Boolean saveDriverLocation(String driverId, Double latitude, Double longitude);

    List<DriverLocationDTO> getNearByDriver(Double longitude, Double latitude);


}
