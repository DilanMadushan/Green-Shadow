package lk.ijse.GreenShadow.util.Convater;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.entity.Crop;
import lk.ijse.GreenShadow.entity.Field;
import lk.ijse.GreenShadow.entity.MonitoringLog;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

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

    public Field convertField(Field foundCField, Field update){
        foundCField.setField_Name(update.getField_Name());
        foundCField.setField_Name(update.getField_Name());
        foundCField.setField_location(update.getField_location());
        foundCField.setField_image_1(update.getField_image_1());
        foundCField.setField_image_2(update.getField_image_2());
        return foundCField;
    }
}
