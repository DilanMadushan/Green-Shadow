package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.dto.EquipmentDetilaisDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDetailsDTO;
import lk.ijse.GreenShadow.repository.EquipmentDetailsRepo;
import lk.ijse.GreenShadow.service.EquipmentDetailsService;
import lk.ijse.GreenShadow.service.EqupimentService;
import lk.ijse.GreenShadow.util.enums.EquipmentStatus;
import lk.ijse.GreenShadow.util.enums.ResavationType;
import lk.ijse.GreenShadow.util.enums.Status;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class EquipmentDetailsServiceImpl implements EquipmentDetailsService {
    private final EquipmentDetailsRepo equipmentDetailsRepo;
    private final EqupimentService equpimentService;
    private final Map map;
    @Override
    public void saveEquipmentdetailsDto(EquipmentDetilaisDTO equipmentDetilaisDTO) {
        if (equipmentDetailsRepo.existsById(equipmentDetilaisDTO.getDetailId())) throw  new AlradyExsistException("Equipment Detail Alrady Exsist");
        equipmentDetailsRepo.save(map.toEquipmentDetalsEntity(equipmentDetilaisDTO));
        if(equipmentDetilaisDTO.getResavationType() == ResavationType.PICKUP){
            equpimentService.updateStatus(equipmentDetilaisDTO.getEquipment_Id(), EquipmentStatus.IN_USE);
        }else{
            equpimentService.updateStatus(equipmentDetilaisDTO.getEquipment_Id(),EquipmentStatus.AVAILABLE);
        }

    }

    @Override
    public List<FilterEquipmentDetailsDTO> getAllEquipment(FilterEquipmentDetailsDTO filterEquipmentDetailsDTO) {
        return null;
    }

}
