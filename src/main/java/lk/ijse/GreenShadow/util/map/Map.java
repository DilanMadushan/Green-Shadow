package lk.ijse.GreenShadow.util.map;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.dto.FieldDTO;
import lk.ijse.GreenShadow.dto.StaffDTO;
import lk.ijse.GreenShadow.entity.Crop;
import lk.ijse.GreenShadow.entity.Field;
import lk.ijse.GreenShadow.entity.Staff;
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

    public Field toFieldEntity(FieldDTO fieldDTO){
        return modelMapper.map(fieldDTO, Field.class);
    }

    public FieldDTO toFieldDto(Field field){
        return modelMapper.map(field, FieldDTO.class);
    }

    public Staff toStaffEntity(StaffDTO staffDto){
        return modelMapper.map(staffDto, Staff.class);
    }

    public StaffDTO toStaffDto(Staff staff){
        return modelMapper.map(staff, StaffDTO.class);
    }
}
