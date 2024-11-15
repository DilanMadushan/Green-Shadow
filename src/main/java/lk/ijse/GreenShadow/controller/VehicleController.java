package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.VehicleDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleDTO;
import lk.ijse.GreenShadow.service.VehicleService;
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
@RequestMapping("api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController{
    private final VehicleService vehicleService;
    @GetMapping("/health")
    public String vehicaleHealthCheack(){
        return "All systems are running optimally";
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
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

    @PatchMapping
    public ResponseEntity<?> updateVehicle(@RequestBody VehicleDTO vehicleDTO){
        try {
            vehicleService.updateVehicle(vehicleDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteVEhicle(@PathVariable("id") String id){
        try {
            vehicleService.deleteVehicle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping
    public List<VehicleDTO> gelALlVehicle(
            @RequestParam(required = false) String data,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int perPage
    ){
        FilterVehicleDTO filterVehicleDTO = new FilterVehicleDTO(data,page,perPage);
        return vehicleService.getAllVehicles(filterVehicleDTO);
    }

    @GetMapping(value = "{id}")
    public VehicleDTO findVehicle(@PathVariable("id")String id){
        return vehicleService.findVehicle(id);
    }
    @GetMapping("/last")
    public String findLastIndex(){
        return vehicleService.getLastIndex();
    }
}
