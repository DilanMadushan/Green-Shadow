package lk.ijse.GreenShadow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("api.v1/equipment")
@RequiredArgsConstructor
public class EquipmentController {
    @GetMapping("/health")
    public String healthCheack(){
        return "All systems are running optimally";
    }
}
