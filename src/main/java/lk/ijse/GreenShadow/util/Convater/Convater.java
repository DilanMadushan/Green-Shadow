package lk.ijse.GreenShadow.util.Convater;

import jakarta.persistence.*;
import lk.ijse.GreenShadow.dto.CropDTO;
import lk.ijse.GreenShadow.entity.*;
import lk.ijse.GreenShadow.util.enums.*;
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

        return foundStaff;
    }

    public Vehicle convertVehicle(Vehicle foundVehicle, Vehicle update) {
        foundVehicle.setVehicle_code(update.getVehicle_code());
        foundVehicle.setLicense_plate_number(update.getLicense_plate_number());
        foundVehicle.setVehicle_category(update.getVehicle_category());
        foundVehicle.setFuel_type(update.getFuel_type());
        foundVehicle.setStatus(update.getStatus());
        foundVehicle.setRemarks(update.getRemarks());
        return foundVehicle;
    }

    public Equipment convertEquipment(Equipment found, Equipment update) {
        found.setEquipment_Id(update.getEquipment_Id());
        found.setName(update.getName());
        found.setType(update.getType());
        found.setStatus(update.getStatus());
        return found;
    }

    public MonitoringLog convertMonitoringLog(MonitoringLog found, MonitoringLog update) {
        found.setLog_code(update.getLog_code());
        found.setLog_date(update.getLog_date());
        found.setLog_details(update.getLog_details());
        found.setObserved_image(update.getObserved_image());
        found.setField(update.getField());
        found.setCrop(update.getCrop());
        found.setStaff(update.getStaff());

        return found;
    }

    public User convertUser(User found,User update){
        found.setEmail(update.getEmail());
        found.setPassword(update.getPassword());
        found.setRole(update.getRole());
        return found
    }



}
