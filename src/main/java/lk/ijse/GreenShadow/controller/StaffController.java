package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.StaffDto;
import lk.ijse.GreenShadow.dto.filter.dto.FilterStuffDto;
import lk.ijse.GreenShadow.service.StaffService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;
    @GetMapping("/health")
    public String healthCheask(){
        return "All systems are running optimally";
    }

    @PostMapping
    public ResponseEntity<?> saveStaff(@RequestBody StaffDto staffDto){
        try {
            staffService.saveStaff(staffDto);
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
    public ResponseEntity<?> updateStaff(@RequestBody StaffDto staffDto){
        try {
            staffService.updateStaff(staffDto);
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
    public ResponseEntity<?> deleteStaff(@PathVariable("id") String id){
        try {
            staffService.deleteStaff(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<StaffDto> getAllStuff(
            @RequestParam(required = false) String data,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int perPage
    ){
        FilterStuffDto filterStuffDto = new FilterStuffDto(data,page,perPage);
        return staffService.getAllStaff(filterStuffDto);
    }

    @GetMapping(value = "{id}")
    public StaffDto findStaff(@PathVariable("id") String id){
        return staffService.findStaff(id);
    }

    @GetMapping("/last")
    public String findLastIndex(){
        return staffService.getLastIndex();
    }

}
