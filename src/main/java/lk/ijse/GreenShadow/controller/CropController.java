package lk.ijse.GreenShadow.controller;


import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterCropDTO;
import lk.ijse.GreenShadow.service.CropService;
import lk.ijse.GreenShadow.util.enums.Category;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crop")
@RequiredArgsConstructor
public class CropController {
    private final CropService cropService;
    private static final Logger logger = LoggerFactory.getLogger(CropController.class);
    @GetMapping("health")
    public String helthChack(){
        return "All systems are running optimally";
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCrop(@RequestBody CropDTO cropDTO){

        try{
            cropService.saveCrop(cropDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (AlradyExsistException e){
          logger.error("Save Crop : "+e.getMessage());
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            logger.error("Save Crop : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @PatchMapping
    public ResponseEntity<?> updateCrop(@RequestBody CropDTO cropDTO){

        try{
            cropService.updateCrop(cropDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException e){
            logger.error("update Crop : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            logger.error("update Crop : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteCrop(@PathVariable("id") String id){
        try {
            cropService.deleteCrop(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NotFoundException e){
            logger.error("delete Crop : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            logger.error("delete Crop : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CropDTO> getAllCrop(
            @RequestParam(required = false) String data,
            @RequestParam(required = false) Category category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int perPage
            ){
        FilterCropDTO filterCropDto = new FilterCropDTO(data,category,page,perPage);
        return cropService.getAllCrop(filterCropDto);
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('SCIENTIST')")
    @GetMapping(value = "{id}")
    public CropDTO findCrop(@PathVariable("id") String id){
        return cropService.findCrop(id);
    }

    @GetMapping("/last")
    public String getLastIndex(){
        return cropService.getLastIndex();
    }


}
