package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.VehicleDTO;
import lk.ijse.GreenShadow.service.VehicleService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController{
    private final VehicleService vehicleService;
    @GetMapping("/health")
    public String vehicaleHealthCheack(){
        return "All systems are running optimally";
    }

    @PostMapping
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        try {
            vehicleService.saveVehicle(vehicleDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (AlradyExsistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
