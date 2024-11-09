package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.EquipmentDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDTO;
import lk.ijse.GreenShadow.service.EqupimentService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping
    public ResponseEntity<?> updateEquipment(@RequestBody EquipmentDTO equipmentDTO){
        try {
            equpimentService.updateEqupiment(equipmentDTO);
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
    public ResponseEntity<?> deleteEquipment(@PathVariable("id") String id){
        try {
            equpimentService.deleteEqupiment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<EquipmentDTO> getAllEquipment(
            @RequestParam(required = false) String data,
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "10")int perPage
    ){
        FilterEquipmentDTO filterEquipmentDTO = new FilterEquipmentDTO(data,page,perPage);
        return equpimentService.getALlEqupiment(filterEquipmentDTO);

    }

    @GetMapping(value = "{id}")
    public EquipmentDTO findEquipment(@PathVariable("id")String id){
        return equpimentService.findEquipment(id);
    }


}
