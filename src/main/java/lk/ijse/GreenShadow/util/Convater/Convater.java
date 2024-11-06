package lk.ijse.GreenShadow.util.Convater;

import jakarta.persistence.*;
import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.entity.*;
import lk.ijse.GreenShadow.util.enums.Designation;
import lk.ijse.GreenShadow.util.enums.Gender;
import lk.ijse.GreenShadow.util.enums.Role;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Date;
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
        foundCField.setExtent_size_of_field(update.getExtent_size_of_field());
        foundCField.setField_location(update.getField_location());
        foundCField.setField_image_1(update.getField_image_1());
        foundCField.setField_image_2(update.getField_image_2());
        return foundCField;
    }

    public Staff convertStaff(Staff foundStaff, Staff update) {
        foundStaff.setFirst_name(update.getFirst_name());
        foundStaff.setLast_name(update.getLast_name());
        foundStaff.setDesignation(update.getDesignation());
        foundStaff.setGender(update.getGender());
        foundStaff.setJoinedDate(update.getJoinedDate());
        foundStaff.setDob(update.getDob());
        foundStaff.setAddress_line_1(update.getAddress_line_1());
        foundStaff.setAddress_line_2(update.getAddress_line_2());
        foundStaff.setAddress_line_3(update.getAddress_line_3());
        foundStaff.setAddress_line_4(update.getAddress_line_4());
        foundStaff.setAddress_line_5(update.getAddress_line_5());
        foundStaff.setTel(update.getTel());
        foundStaff.setEmail(update.getEmail());
        foundStaff.setRole(update.getRole());
        foundStaff.setLog(update.getLog());
        foundStaff.setVehicle(update.getVehicle());

        return foundStaff;
    }

}
