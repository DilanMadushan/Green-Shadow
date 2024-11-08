package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterCropDTO;
import lk.ijse.GreenShadow.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CropService{
    void saveCrop(CropDTO cropDTO);
    void updateCrop(CropDTO cropDTO);
    void deleteCrop(String id);
    List<CropDTO> getAllCrop(FilterCropDTO filterCropDto);
    CropDTO findCrop(String id);
    String getLastIndex();
}
