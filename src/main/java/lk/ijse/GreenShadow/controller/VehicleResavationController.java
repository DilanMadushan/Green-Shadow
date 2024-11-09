package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.VehicleResavationDTO;
import lk.ijse.GreenShadow.service.VehicleResavationService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/resavation")
@RequiredArgsConstructor
public class VehicleResavationController {
    private final VehicleResavationService vehicleResavationService;
    @PostMapping
    public ResponseEntity<?> saveResavation(@RequestBody VehicleResavationDTO vehicleResavationDTO){
        try {
            vehicleResavationService.saveResavation(vehicleResavationDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (AlradyExsistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (NotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
