package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.dto.EquipmentDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDTO;
import lk.ijse.GreenShadow.service.EqupimentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EqupimentServiceImpl implements EqupimentService {
    @Override
    public void saveEqupiment() {

    }

    @Override
    public void updateEqupiment() {

    }

    @Override
    public void deleteEqupiment() {

    }

    @Override
    public List<EquipmentDTO> getALlEqupiment(FilterEquipmentDTO filterEquipmentDTO) {
        return null;
    }

    @Override
    public EquipmentDTO findEquipment() {
        return null;
    }

    @Override
    public String findLastIndex() {
        return null;
    }
}
