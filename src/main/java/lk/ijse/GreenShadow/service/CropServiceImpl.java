package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.repository.CropRepo;
import lk.ijse.GreenShadow.util.Map;
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
    @Override
    public void saveCrop(CropDTO cropDTO) {
        cropRepo.save(map.toCropEntity(cropDTO));
    }

    @Override
    public void updateCrop(CropDTO cropDTO) {

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
