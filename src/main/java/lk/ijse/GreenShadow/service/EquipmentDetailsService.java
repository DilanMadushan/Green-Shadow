package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDetailsDTO;

import java.util.List;

public interface EquipmentDetailsService {
    void saveEquipmentdetailsDto();
    List<FilterEquipmentDetailsDTO> getAllEquipment(FilterEquipmentDetailsDTO filterEquipmentDetailsDTO);
}
