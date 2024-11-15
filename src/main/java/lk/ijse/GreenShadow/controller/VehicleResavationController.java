package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.VehicleResavationDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleResavationDTO;
import lk.ijse.GreenShadow.entity.VehicleResavation;
import lk.ijse.GreenShadow.service.VehicleResavationService;
import lk.ijse.GreenShadow.util.enums.ResavationType;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/resavation")
@RequiredArgsConstructor
public class VehicleResavationController {
    private final VehicleResavationService vehicleResavationService;
    @GetMapping("health")
    public String helthChack(){
        return "All systems are running optimally";
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
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

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @GetMapping
    public List<VehicleResavationDTO> getAllResavation(
            @RequestParam(required = false)String data,
            @RequestParam(required = false) ResavationType type,
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "10")int perPage
    ){
        FilterVehicleResavationDTO filterVehicleResavationDTO =new FilterVehicleResavationDTO(
                data,
                type,
                page,
                perPage
        );
        return vehicleResavationService.getAllResavation(filterVehicleResavationDTO);
    }
}
