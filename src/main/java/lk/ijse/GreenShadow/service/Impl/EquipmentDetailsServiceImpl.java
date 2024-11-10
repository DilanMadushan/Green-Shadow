package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDetailsDTO;
import lk.ijse.GreenShadow.service.EquipmentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class EquipmentDetailsServiceImpl implements EquipmentDetailsService {
    @Override
    public void saveEquipmentdetailsDto() {

    }

    @Override
    public List<FilterEquipmentDetailsDTO> getAllEquipment(FilterEquipmentDetailsDTO filterEquipmentDetailsDTO) {
        return null;
    }
}
