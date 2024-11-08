package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.Specification.StaffSpecification;
import lk.ijse.GreenShadow.dto.StaffDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterStuffDTO;
import lk.ijse.GreenShadow.entity.Staff;
import lk.ijse.GreenShadow.repository.StaffRepo;
import lk.ijse.GreenShadow.service.StaffService;
import lk.ijse.GreenShadow.util.Convater.Convater;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepo staffRepo;
    private final Map map;
    private final Convater convater;
    @Override
    public void saveStaff(StaffDTO staffDto) {
        if (staffRepo.existsById(staffDto.getStaff_id())) throw new AlradyExsistException("Member Alrady Exsist");
        staffRepo.save(map.toStaffEntity(staffDto));
    }

    @Override
    public void updateStaff(StaffDTO staffDto) {
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
    public List<StaffDTO> getAllStaff(FilterStuffDTO filterStuffDto) {
        Pageable pageable = PageRequest.of(filterStuffDto.getPage(), filterStuffDto.getPerPage());
        Specification<Staff> specification = StaffSpecification.createSpecification(filterStuffDto);

        Page<Staff> resualt = staffRepo.findAll(specification,pageable);
        List<StaffDTO> staff = new ArrayList<>();

        for (Staff staffSet : resualt) {
            staff.add(map.toStaffDto(staffSet));
        }
        return staff;
    }

    @Override
    public StaffDTO findStaff(String id) {
        Optional<Staff> byId = staffRepo.findById(id);

        if (byId.isPresent()) {
            return map.toStaffDto(byId.get());
        }
        return null;
    }

    @Override
    public String getLastIndex() {
        return staffRepo.findLastIndex();
    }
}
