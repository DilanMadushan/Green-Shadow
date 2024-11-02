package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.FieldDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDto;
import lk.ijse.GreenShadow.service.FieldService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/field")
@RequiredArgsConstructor
public class FieldController {
    private final FieldService fieldService;
    @GetMapping("/health")
    public String healthCheck(){
        return "All systems are running optimally";
    }


}