package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.StaffDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterStuffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDto);
    void updateStaff(StaffDTO staffDto);
    void deleteStaff(String id);
    List<StaffDTO> getAllStaff(FilterStuffDTO filterStuffDto);
    StaffDTO findStaff(String id);
    String getLastIndex();
}
