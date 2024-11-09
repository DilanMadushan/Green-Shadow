package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.VehicleDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleDTO;
import lk.ijse.GreenShadow.util.enums.Status;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    void updateVehicle(VehicleDTO vehicleDTO);
    void deleteVehicle(String id);
    List<VehicleDTO> getAllVehicles(FilterVehicleDTO filterVehicleDTO);
    VehicleDTO findVehicle(String id);
    String getLastIndex();

    void updateStatus(String id, Status status);
}
