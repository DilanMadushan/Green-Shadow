package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.MonitoringLogDTO;
import lk.ijse.GreenShadow.service.MonitoringLogService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/log")
@RequiredArgsConstructor
public class MonitoringLogController {
    private final MonitoringLogService monitoringLogService;
    @GetMapping("health")
    public String helthChack(){
        return "All systems are running optimally";
    }

    @PostMapping
    public ResponseEntity<?> saveMoniteringLog(@RequestBody MonitoringLogDTO monitoringLogDTO){
        try {
            System.out.println(monitoringLogDTO.toString());
            monitoringLogService.saveMonitoringLogDetail(monitoringLogDTO);
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
    public ResponseEntity<?> updateMonitoringLog(@RequestBody MonitoringLogDTO monitoringLogDTO){
        try {
            monitoringLogService.updateMonitoringLogDetail(monitoringLogDTO);
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
    public ResponseEntity<?> deleteMonitoringLog(@PathVariable("id") String id){
        try {
            monitoringLogService.deleteMonitoringLogDetail(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
