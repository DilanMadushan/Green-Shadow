package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.EquipmentDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDTO;

import java.util.List;

public interface EqupimentService {
    void saveEqupiment(EquipmentDTO equipmentDTO);
    void updateEqupiment(EquipmentDTO equipmentDTO);
    void deleteEqupiment(String id);
    List<EquipmentDTO> getALlEqupiment(FilterEquipmentDTO filterEquipmentDTO);
    EquipmentDTO findEquipment(String id);
    String findLastIndex();
}
