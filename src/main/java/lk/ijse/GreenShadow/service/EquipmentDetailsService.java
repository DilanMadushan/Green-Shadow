package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.EquipmentDetilaisDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDetailsDTO;

import java.util.List;

public interface EquipmentDetailsService {
    void saveEquipmentdetailsDto(EquipmentDetilaisDTO equipmentDetilaisDTO);
    List<EquipmentDetilaisDTO> getAllEquipment(FilterEquipmentDetailsDTO filterEquipmentDetailsDTO);
    String findLastIndex();
}
