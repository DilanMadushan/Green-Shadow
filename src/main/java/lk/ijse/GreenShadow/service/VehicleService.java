package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.VehicleDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    void updateVehicle(VehicleDTO vehicleDTO);
    void deleteVehicle(String id);
    List<VehicleDTO> getAllVehicles(FilterVehicleDTO filterVehicleDTO);
    VehicleDTO findVehicle(String id);
    String getLastIndex();
}
