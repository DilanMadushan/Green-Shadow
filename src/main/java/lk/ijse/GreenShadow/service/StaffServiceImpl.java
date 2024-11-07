package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.StaffDto;
import lk.ijse.GreenShadow.dto.filter.dto.FilterStuffDto;
import lk.ijse.GreenShadow.entity.Staff;
import lk.ijse.GreenShadow.repository.StaffRepo;
import lk.ijse.GreenShadow.util.Convater.Convater;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepo staffRepo;
    private final Map map;
    private final Convater convater;
    @Override
    public void saveStaff(StaffDto staffDto) {
        if (staffRepo.existsById(staffDto.getStaff_id())) throw new AlradyExsistException("Member Alrady Exsist");
        staffRepo.save(map.toStaffEntity(staffDto));
    }

    @Override
    public void updateStaff(StaffDto staffDto) {
        Staff found = staffRepo.findById(staffDto.getStaff_id()).orElseThrow(() -> new NotFoundException("Member not Found"));
        Staff update = map.toStaffEntity(staffDto);
        convater.convertStaff(found,update);
    }

    @Override
    public void deleteStaff(String id) {
        staffRepo.findById(id).orElseThrow(()-> new NotFoundException("Member not Found"));
        staffRepo.deleteById(id);
    }

    @Override
    public List<StaffDto> getAllStaff(FilterStuffDto filterStuffDto) {
        return null;
    }

    @Override
    public String findStaff(String id) {
        return null;
    }

    @Override
    public String getLastIndex() {
        return null;
    }
}
