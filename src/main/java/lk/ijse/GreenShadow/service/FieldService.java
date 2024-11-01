package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.dto.FieldDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterCropDto;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDto;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    void updateField(FieldDTO fieldDTO);
    void deleteField(String id);
    List<CropDTO> getAllField(FilterFieldDto filterFieldDto);
    CropDTO findField(String id);
    String getLastIndex();
}
