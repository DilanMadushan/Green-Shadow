package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.Specification.FieldSpecification;
import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.dto.FieldDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDto;
import lk.ijse.GreenShadow.entity.Field;
import lk.ijse.GreenShadow.repository.FieldRepo;
import lk.ijse.GreenShadow.util.Convater.Convater;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class FieldServiceImpl implements FieldService {
    private final FieldRepo fieldRepo;
    private final Map map;
    private final Convater convater;
    @Override
    public void saveField(FieldDTO fieldDTO) {
        if(fieldRepo.existsById(fieldDTO.getField_code())) throw new AlradyExsistException("Field Alrady Exsist");
        fieldRepo.save(map.toFieldEntity(fieldDTO));
    }

    @Override
    public void updateField(FieldDTO fieldDTO) {
        Field found = fieldRepo.findById(fieldDTO.getField_code()).orElseThrow(() -> new NotFoundException("Field Not Found"));
        Field update = map.toFieldEntity(fieldDTO);
        convater.convertField(found,update);
    }

    @Override
    public void deleteField(String id) {
        fieldRepo.findById(id).orElseThrow(() -> new NotFoundException("Field Not Found"));
        fieldRepo.deleteById(id);
    }

    @Override
    public List<FieldDTO> getAllField(FilterFieldDto filterFieldDto) {
        Pageable pageable = PageRequest.of(filterFieldDto.getPage(), filterFieldDto.getPerPage());
        Specification<Field> specification = FieldSpecification.createSpecification(filterFieldDto);

        Page<Field> resualt = fieldRepo.findAll(specification,pageable);

        List<FieldDTO> fields = new ArrayList<>();

        for (Field field : resualt) {
            fields.add(map.toFieldDto(field));
        }
        return fields;
    }

    @Override
    public FieldDTO findField(String id) {
        Optional<Field> byId = fieldRepo.findById(id);
        if (byId.isPresent()) {
            return map.toFieldDto(byId.get());
        }
        return null;
    }

    @Override
    public String getLastIndex() {
        return fieldRepo.getLastIndex();
    }
}
