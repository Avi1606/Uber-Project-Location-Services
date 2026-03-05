package org.avi1606.uberprojectlocationsevices.controllers;

import lombok.RequiredArgsConstructor;
import org.avi1606.uberprojectlocationsevices.dto.DriverLocationDTO;
import org.avi1606.uberprojectlocationsevices.dto.NearByDriverRequestDTO;
import org.avi1606.uberprojectlocationsevices.dto.SaveDriverLocationRequestDTO;
import org.avi1606.uberprojectlocationsevices.services.LocationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/location ")
public class LocationController {

    private final LocationServiceImpl locationService;


    @PostMapping("/drivers")
    public ResponseEntity<Boolean> saveDriverLocation(@RequestBody SaveDriverLocationRequestDTO saveDriverLocationRequestDTO) {
        try {
            Boolean savedDriver = locationService.saveDriverLocation(
                    saveDriverLocationRequestDTO.getDriverId(),
                    saveDriverLocationRequestDTO.getLatitude(),
                    saveDriverLocationRequestDTO.getLongitude());

            return new ResponseEntity<>(savedDriver,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nearby/drivers")
    public ResponseEntity<List<DriverLocationDTO>> getNearByDrivers(@RequestBody NearByDriverRequestDTO nearByDriverRequestDTO) {
        try {
            List<DriverLocationDTO> nearByDriver = locationService.getNearByDriver(
                    nearByDriverRequestDTO.getLongitude(),
                    nearByDriverRequestDTO.getLatitude());

            return new ResponseEntity<>(nearByDriver, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
