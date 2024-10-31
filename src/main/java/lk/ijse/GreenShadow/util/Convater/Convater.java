package lk.ijse.GreenShadow.util.Convater;

import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.entity.Crop;
import org.springframework.stereotype.Component;

@Component
public class Convater {
    public Crop convertCrop(Crop foundCrop,Crop update){
        foundCrop.setCommon_name(update.getCommon_name());
        foundCrop.setScientific_name(update.getScientific_name());
        foundCrop.setCrop_image(update.getCrop_image());
        foundCrop.setCategory(update.getCategory());
        foundCrop.setCrop_season(update.getCrop_season());
        foundCrop.setField(update.getField());
        return foundCrop;
    }
}
