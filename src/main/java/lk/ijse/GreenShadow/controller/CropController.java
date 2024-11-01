package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.dto.FilterCropDto;
import lk.ijse.GreenShadow.service.CropService;
import lk.ijse.GreenShadow.util.enums.Category;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/crop")
@RequiredArgsConstructor
public class CropController {
    private final CropService cropService;
    @GetMapping("health")
    public String helthChack(){
        return "Corp Health";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCrop(@RequestBody CropDTO cropDTO){

        try{
            cropService.saveCrop(cropDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping
    public ResponseEntity<?> updateCrop(@RequestBody CropDTO cropDTO){

        try{
            cropService.updateCrop(cropDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteCrop(@PathVariable("id") String id){
        try {
            cropService.deleteCrop(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public List<CropDTO> getAllCrop(
            @RequestParam(required = false) String data,
            @RequestParam(required = false) Category category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int perPage
            ){
        FilterCropDto filterCropDto = new FilterCropDto(data,category,page,perPage);
        return cropService.getAllCrop(filterCropDto);
    }

    @GetMapping(value = "{id}")
    public CropDTO findCrop(@PathVariable("id") String id){
        return cropService.findCrop(id);
    }

    @GetMapping("/last")
    public String getLastIndex(){
        return cropService.getLastIndex();
    }


}
