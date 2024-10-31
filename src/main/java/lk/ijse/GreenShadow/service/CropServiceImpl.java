package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.entity.Crop;
import lk.ijse.GreenShadow.repository.CropRepo;
import lk.ijse.GreenShadow.util.Convater.Convater;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CropServiceImpl implements CropService{
    private final CropRepo cropRepo;
    private final Map map;
    private final Convater convater;
    @Override
    public void saveCrop(CropDTO cropDTO) {
        cropRepo.save(map.toCropEntity(cropDTO));
    }

    @Override
    public void updateCrop(CropDTO cropDTO) {
        Crop foundCrop = cropRepo.findById(cropDTO.getCrop_code()).orElseThrow(() -> new RuntimeException("Crop Not Found"));
        Crop update = map.toCropEntity(cropDTO);
        convater.convertCrop(foundCrop,update);
    }

    @Override
    public void deleteCrop(CropDTO cropDTO) {

    }

    @Override
    public List<CropDTO> getAllCrop() {
        return null;
    }

    @Override
    public CropDTO findCrop(String id) {
        return null;
    }

    @Override
    public String getLastIndex() {
        return null;
    }
}
