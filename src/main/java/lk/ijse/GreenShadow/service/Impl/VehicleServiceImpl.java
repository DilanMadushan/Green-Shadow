package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.dto.VehicleDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleDTO;
import lk.ijse.GreenShadow.repository.VehicleRepo;
import lk.ijse.GreenShadow.service.VehicleService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepo vehicleRepo;
    private final Map map;
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicle_code())) throw new AlradyExsistException("Vehicle Alrady Exsist");
        vehicleRepo.save(map.toVehicleEntity(vehicleDTO));
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {

    }

    @Override
    public void deleteVehicle(String id) {

    }

    @Override
    public List<VehicleDTO> getAllVehicles(FilterVehicleDTO filterVehicleDTO) {
        return null;
    }

    @Override
    public VehicleDTO findVehicle(String id) {
        return null;
    }

    @Override
    public String getLastIndex() {
        return null;
    }
}
