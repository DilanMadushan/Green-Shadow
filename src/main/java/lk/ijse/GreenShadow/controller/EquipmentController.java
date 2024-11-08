package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.EquipmentDTO;
import lk.ijse.GreenShadow.service.EqupimentService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/equipment")
@RequiredArgsConstructor
public class EquipmentController {
    private final EqupimentService equpimentService;
    @GetMapping("/health")
    public String healthCheack(){
        return "All systems are running optimally";
    }

    @PostMapping
    public ResponseEntity<?> saveEquipment(@RequestBody EquipmentDTO equipmentDTO){
        try {
            equpimentService.saveEqupiment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (AlradyExsistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
