package lk.ijse.GreenShadow.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {
    @GetMapping("/health")
    public String healthCheask(){
        return "All systems are running optimally";
    }

    @PostMapping
    public ResponseEntity<?> saveStaff(){

    }

}
