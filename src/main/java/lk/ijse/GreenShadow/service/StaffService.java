package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.StaffDto;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDto staffDto);
    void updateStaff(StaffDto staffDto);
    void deleteStaff(String id);
    List<StaffDto> getAllStaff();
    String findStaff(String id);
    String getLastIndex();
}
