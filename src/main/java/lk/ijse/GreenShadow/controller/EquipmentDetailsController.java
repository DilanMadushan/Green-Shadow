package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.EquipmentDetilaisDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDetailsDTO;
import lk.ijse.GreenShadow.entity.EquipmentDetails;
import lk.ijse.GreenShadow.service.EquipmentDetailsService;
import lk.ijse.GreenShadow.util.enums.ResavationType;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/equipmentDetails")
@RequiredArgsConstructor
public class EquipmentDetailsController {
    private final EquipmentDetailsService equipmentDetailsService;

    @GetMapping("health")
    public String helthChack(){
        return "All systems are running optimally";
    }
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

    @GetMapping
    public List<EquipmentDetilaisDTO> getAllEquipmentDetails(
            @RequestParam(required = false) String data,
            @RequestParam(required = false) ResavationType type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int perPAge
    ){
        FilterEquipmentDetailsDTO filterEquipmentDetailsDTO = new FilterEquipmentDetailsDTO(
                data,
                type,
                page,
                perPAge
        );
        return equipmentDetailsService.getAllEquipment(filterEquipmentDetailsDTO);
    }
}
