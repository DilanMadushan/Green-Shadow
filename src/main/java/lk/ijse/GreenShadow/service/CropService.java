package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterCropDto;

import java.util.List;

public interface CropService{
    void saveCrop(CropDTO cropDTO);
    void updateCrop(CropDTO cropDTO);
    void deleteCrop(String id);
    List<CropDTO> getAllCrop(FilterCropDto filterCropDto);
    CropDTO findCrop(String id);
    String getLastIndex();
}
