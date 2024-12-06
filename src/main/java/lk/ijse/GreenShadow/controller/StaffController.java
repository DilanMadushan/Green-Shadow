package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.StaffDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterStuffDTO;
import lk.ijse.GreenShadow.service.StaffService;
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
@RequestMapping("api/v1/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(CropController.class);
    @GetMapping("/health")
    public String healthCheask(){
        return "All systems are running optimally";
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @PostMapping
    public ResponseEntity<?> saveStaff(@RequestBody StaffDTO staffDto){
        try {
            staffService.saveStaff(staffDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (AlradyExsistException e){
            logger.error("Save Staff : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            logger.error("Save Staff : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @PatchMapping
    public ResponseEntity<?> updateStaff(@RequestBody StaffDTO staffDto){
        try {
            staffService.updateStaff(staffDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NotFoundException e){
            logger.error("Update Staff : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            logger.error("Update Staff : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteStaff(@PathVariable("id") String id){
        try {
            staffService.deleteStaff(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NotFoundException e){
            logger.error("Delete Staff : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            logger.error("Delete Staff : "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @GetMapping
    public List<StaffDTO> getAllStuff(
            @RequestParam(required = false) String data,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int perPage
    ){
        FilterStuffDTO filterStuffDto = new FilterStuffDTO(data,page,perPage);
        return staffService.getAllStaff(filterStuffDto);
    }

    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMINISTRATIVE')")
    @GetMapping(value = "{id}")
    public StaffDTO findStaff(@PathVariable("id") String id){
        return staffService.findStaff(id);
    }

    @GetMapping("/last")
    public String findLastIndex(){
        return staffService.getLastIndex();
    }

}
