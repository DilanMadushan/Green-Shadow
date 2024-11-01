package lk.ijse.GreenShadow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/field")
@RequiredArgsConstructor
public class FieldController {
    @GetMapping
    public String healthCheck(){
        return "All systems are running optimally";
    }

}
