package lk.ijse.GreenShadow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController{
    @GetMapping("/health")
    public String vehicaleHealthCheack(){
        return "All systems are running optimally";
    }

}
