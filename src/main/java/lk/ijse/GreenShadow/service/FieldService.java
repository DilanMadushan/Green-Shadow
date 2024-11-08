package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.FieldDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    void updateField(FieldDTO fieldDTO);
    void deleteField(String id);
    List<FieldDTO> getAllField(FilterFieldDTO filterFieldDto);
    FieldDTO findField(String id);
    String getLastIndex();
}
