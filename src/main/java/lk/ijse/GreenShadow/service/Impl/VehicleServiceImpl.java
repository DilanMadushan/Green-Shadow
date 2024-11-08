package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.Specification.StaffSpecification;
import lk.ijse.GreenShadow.Specification.VehicleSpecifiction;
import lk.ijse.GreenShadow.dto.VehicleDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleDTO;
import lk.ijse.GreenShadow.entity.Staff;
import lk.ijse.GreenShadow.entity.Vehicle;
import lk.ijse.GreenShadow.repository.VehicleRepo;
import lk.ijse.GreenShadow.service.VehicleService;
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
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepo vehicleRepo;
    private final Map map;
    private final Convater convater;
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicle_code())) throw new AlradyExsistException("Vehicle Alrady Exsist");
        vehicleRepo.save(map.toVehicleEntity(vehicleDTO));
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        Vehicle found = vehicleRepo.findById(vehicleDTO.getVehicle_code()).orElseThrow(() -> new NotFoundException("Vehicle not Found"));
        Vehicle update = map.toVehicleEntity(vehicleDTO);
        convater.convertVehicle(found,update);
    }

    @Override
    public void deleteVehicle(String id) {
        vehicleRepo.findById(id).orElseThrow(()-> new NotFoundException("Vehicle Not Found"));
        vehicleRepo.deleteById(id);
    }

    @Override
    public List<VehicleDTO> getAllVehicles(FilterVehicleDTO filterVehicleDTO) {
        Pageable pageable = PageRequest.of(filterVehicleDTO.getPage(), filterVehicleDTO.getPerPage());
        Specification<Vehicle> specification = VehicleSpecifiction.createSpecification(filterVehicleDTO);

        Page<Vehicle> resualt = vehicleRepo.findAll(specification,pageable);
        List<VehicleDTO> vehicles = new ArrayList<>();

        for (Vehicle vehicle : resualt) {
            vehicles.add(map.toVehicleDto(vehicle));
        }

        return vehicles;
    }

    @Override
    public VehicleDTO findVehicle(String id) {
        Optional<Vehicle> byId = vehicleRepo.findById(id);

        if (byId.isPresent()) {
            return map.toVehicleDto(byId.get());
        }
        return null;
    }

    @Override
    public String getLastIndex() {
        return null;
    }
}
