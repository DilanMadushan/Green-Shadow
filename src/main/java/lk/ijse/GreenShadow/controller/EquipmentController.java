package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.EquipmentDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDTO;
import lk.ijse.GreenShadow.service.EqupimentService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/equipment")
@RequiredArgsConstructor
public class EquipmentController {
    private final EqupimentService equpimentService;
    private static final Logger logger = LoggerFactory.getLogger(CropController.class);
    @GetMapping("/health")
    public String healthCheack(){
        return "All systems are running optimally";
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @PostMapping
    public ResponseEntity<?> saveEquipment(@RequestBody EquipmentDTO equipmentDTO){
        try {
            equpimentService.saveEqupiment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (AlradyExsistException e){
            logger.error("save Equipment : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            logger.error("save Equipment : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @PatchMapping
    public ResponseEntity<?> updateEquipment(@RequestBody EquipmentDTO equipmentDTO){
        try {
            equpimentService.updateEqupiment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException e){
            logger.error("update Equipment : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            logger.error("update Equipment : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteEquipment(@PathVariable("id") String id){
        try {
            equpimentService.deleteEqupiment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e){
            logger.error("delete Equipment : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            logger.error("delete Equipment : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @GetMapping
    public List<EquipmentDTO> getAllEquipment(
            @RequestParam(required = false) String data,
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "100")int perPage
    ){
        FilterEquipmentDTO filterEquipmentDTO = new FilterEquipmentDTO(data,page,perPage);
        return equpimentService.getALlEqupiment(filterEquipmentDTO);

    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @GetMapping(value = "{id}")
    public EquipmentDTO findEquipment(@PathVariable("id")String id){
        return equpimentService.findEquipment(id);
    }

    @GetMapping("/last")
    public String findLastIndex(){
        return equpimentService.findLastIndex();
    }


}
