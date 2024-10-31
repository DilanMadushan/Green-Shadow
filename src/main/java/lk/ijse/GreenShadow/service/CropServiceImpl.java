package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.entity.Crop;
import lk.ijse.GreenShadow.repository.CropRepo;
import lk.ijse.GreenShadow.util.Convater.Convater;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Crop foundCrop = cropRepo.findById(cropDTO.getCrop_code()).orElseThrow(() -> new NotFoundException("Crop Not Found"));
        Crop update = map.toCropEntity(cropDTO);
        convater.convertCrop(foundCrop,update);
    }

    @Override
    public void deleteCrop(String id) {
        cropRepo.findById(id).orElseThrow(()->new NotFoundException("Crop NotFound"));
        cropRepo.deleteById(id);
    }

    @Override
    public List<CropDTO> getAllCrop() {
        List<Crop> finded = cropRepo.findAll();
        List<CropDTO> dtoList = new ArrayList<>();

        for (Crop crop : finded) {
            dtoList.add(map.toCropDto(crop));
        }
        return dtoList;
    }

    @Override
    public CropDTO findCrop(String id) {
        Optional<Crop> byId = cropRepo.findById(id);
        if(byId.isPresent()){
            return map.toCropDto(byId.get());
        }
        return null;
    }

    @Override
    public String getLastIndex() {
        return cropRepo.lastIndex();
    }
}
