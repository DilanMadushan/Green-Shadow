package lk.ijse.GreenShadow.controller;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.service.CropService;
import lk.ijse.GreenShadow.util.ImageConvater;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/crop")
@RequiredArgsConstructor
public class CropController {
    private final CropService cropService;
    private final ImageConvater imageConvater;
    @GetMapping("health")
    public String helthChack(){
        return "Corp Health";
    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveCrop(
            @RequestPart("crop_code")String crop_code,
            @RequestPart("common_name")String common_name,
            @RequestPart("scientific_name")String scientific_name,
            @RequestPart("crop_image") MultipartFile crop_image,
            @RequestPart("category")String category,
            @RequestPart("crop_season")String crop_season,
            @RequestPart("fieldId")String fieldId
    ){

        try{
            String image =imageConvater.imageToBase65(crop_image);

            CropDTO cropDTO = new CropDTO(
                    crop_code,
                    common_name,
                    scientific_name,
                    image,
                    category,
                    crop_season,
                    fieldId,
                    new ArrayList<>()
            );

            cropService.saveCrop(cropDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);


        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
