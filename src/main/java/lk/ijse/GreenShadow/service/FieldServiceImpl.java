package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.dto.FieldDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {
    @Override
    public void saveField(FieldDTO fieldDTO) {

    }

    @Override
    public void updateField(FieldDTO fieldDTO) {

    }

    @Override
    public void deleteField(String id) {

    }

    @Override
    public List<CropDTO> getAllField(FilterFieldDto filterFieldDto) {
        return null;
    }

    @Override
    public CropDTO findField(String id) {
        return null;
    }

    @Override
    public String getLastIndex() {
        return null;
    }
}
