package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.dto.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    void updateField(FieldDTO fieldDTO);
    void deleteField(String id);
    List<FieldDTO> getAllField();
    CropDTO findField(String id);
    String getLastIndex();
}