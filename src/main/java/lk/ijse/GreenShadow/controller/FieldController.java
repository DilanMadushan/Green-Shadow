package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.FieldDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDTO;
import lk.ijse.GreenShadow.service.FieldService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/field")
@RequiredArgsConstructor
public class FieldController {
    private final FieldService fieldService;
    private static final Logger logger = LoggerFactory.getLogger(CropController.class);
    @GetMapping("/health")
    public String healthCheck(){
        return "All systems are running optimally";
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @PostMapping
    public ResponseEntity<?> saveField(@RequestBody FieldDTO fieldDTO){
        try {
            fieldService.saveField(fieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (AlradyExsistException e){
            logger.error("save Field : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("save Field : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteField(@PathVariable("id") String id){
        try {
            fieldService.deleteField(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NotFoundException e){
            logger.error("Delete Field : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Delete Field : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @PatchMapping
    public ResponseEntity<?> updateField(@RequestBody FieldDTO fieldDTO){
        try {
            fieldService.updateField(fieldDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException e){
            logger.error("Delete Field : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            logger.error("Delete Field : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDTO> getAllFields(
            @RequestParam(required = false) String data,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int perPage
    ){
        FilterFieldDTO filterFieldDto = new FilterFieldDTO(data,page,perPage);
        return fieldService.getAllField(filterFieldDto);
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @GetMapping("/last")
    public String findLastIndex(){
        return fieldService.getLastIndex();
    }

    @GetMapping(value = "{id}")
    public FieldDTO findField(@PathVariable("id") String id){
        return fieldService.findField(id);
    }
}
