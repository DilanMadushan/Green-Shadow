package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.dto.EquipmentDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDTO;
import lk.ijse.GreenShadow.entity.Equipment;
import lk.ijse.GreenShadow.repository.EquipmentRepo;
import lk.ijse.GreenShadow.service.EqupimentService;
import lk.ijse.GreenShadow.util.Convater.Convater;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EqupimentServiceImpl implements EqupimentService {
    private final EquipmentRepo equipmentRepo;
    private final Map map;
    private final Convater convater;
    @Override
    public void saveEqupiment(EquipmentDTO equipmentDTO) {
        if (equipmentRepo.existsById(equipmentDTO.getEquipment_Id()))throw new AlradyExsistException("Equipment Alrady Exsist");
        equipmentRepo.save(map.toEquipmentEntity(equipmentDTO));
    }

    @Override
    public void updateEqupiment(EquipmentDTO equipmentDTO) {
        Equipment found = equipmentRepo.findById(equipmentDTO.getEquipment_Id()).orElseThrow(() -> new NotFoundException("Equipment Not Found"));
        Equipment update = map.toEquipmentEntity(equipmentDTO);
        convater.convertEquipment(found,update);
    }

    @Override
    public void deleteEqupiment(String id) {

    }

    @Override
    public List<EquipmentDTO> getALlEqupiment(FilterEquipmentDTO filterEquipmentDTO) {
        return null;
    }

    @Override
    public EquipmentDTO findEquipment(String id) {
        return null;
    }

    @Override
    public String findLastIndex() {
        return null;
    }
}
