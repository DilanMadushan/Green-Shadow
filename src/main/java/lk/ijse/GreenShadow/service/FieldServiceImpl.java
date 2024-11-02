package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.dto.FieldDTO;
import lk.ijse.GreenShadow.entity.Field;
import lk.ijse.GreenShadow.repository.FieldRepo;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class FieldServiceImpl implements FieldService {
    private final FieldRepo fieldRepo;
    private final Map map;
    @Override
    public void saveField(FieldDTO fieldDTO) {
        if(fieldRepo.existsById(fieldDTO.getField_code())) throw new AlradyExsistException("Field Alrady Exsist");
        fieldRepo.save(map.toFieldEntity(fieldDTO));
    }

    @Override
    public void updateField(FieldDTO fieldDTO) {

    }

    @Override
    public void deleteField(String id) {

    }

    @Override
    public List<FieldDTO> getAllField() {
        List<Field> all = fieldRepo.findAll();
        List<FieldDTO> set = new ArrayList<>();

        for (Field field : all) {
            set.add(map.toFieldDto(field));
        }
        return set;
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
