package lk.ijse.GreenShadow.util.map;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.entity.Crop;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Map {
    private final ModelMapper modelMapper;
    public Crop toCropEntity(CropDTO cropDTO){
        return modelMapper.map(cropDTO, Crop.class);
    }

    public CropDTO toCropDto(Crop crop){
        return modelMapper.map(crop, CropDTO.class);
    }
}
