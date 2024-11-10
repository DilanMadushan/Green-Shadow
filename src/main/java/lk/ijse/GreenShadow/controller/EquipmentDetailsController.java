package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.EquipmentDetilaisDTO;
import lk.ijse.GreenShadow.service.EquipmentDetailsService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/vi/equipmentDetails")
@RequiredArgsConstructor
public class EquipmentDetailsController {
    private final EquipmentDetailsService equipmentDetailsService;
    @PostMapping
    public ResponseEntity<?> saveEquipmentDetals(@RequestBody EquipmentDetilaisDTO equipmentDetilaisDTO){
        try {
            equipmentDetailsService.saveEquipmentdetailsDto(equipmentDetilaisDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (AlradyExsistException e){
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
