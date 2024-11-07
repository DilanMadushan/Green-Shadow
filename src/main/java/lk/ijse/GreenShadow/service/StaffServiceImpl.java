package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.StaffDto;
import lk.ijse.GreenShadow.dto.filter.dto.FilterStuffDto;
import lk.ijse.GreenShadow.repository.StaffRepo;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
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
    @Override
    public void saveStaff(StaffDto staffDto) {
        if (staffRepo.existsById(staffDto.getStaff_id())) throw new AlradyExsistException("Member Alrady Exsist");
        staffRepo.save(map.toStaffEntity(staffDto));
    }

    @Override
    public void updateStaff(StaffDto staffDto) {

    }

    @Override
    public void deleteStaff(String id) {

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
