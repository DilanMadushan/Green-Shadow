package lk.ijse.GreenShadow.util.map;

import lk.ijse.GreenShadow.dto.*;
import lk.ijse.GreenShadow.entity.*;
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

    public Vehicle toVehicleEntity(VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }

    public VehicleDTO toVehicleDto(Vehicle vehicle){
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    public Equipment toEquipmentEntity(EquipmentDTO equipmentDTO){
        return modelMapper.map(equipmentDTO, Equipment.class);
    }
    public EquipmentDTO toEquipmentDto(Equipment equipment){
        return modelMapper.map(equipment, EquipmentDTO.class);
    }

    public VehicleResavation toVehicleResavationEntity(VehicleResavationDTO resavationDTO){
        return modelMapper.map(resavationDTO, VehicleResavation.class);
    }

    public VehicleResavationDTO toVehicleResavationDTO(VehicleResavation resavation){
        return modelMapper.map(resavation, VehicleResavationDTO.class);
    }
}
