package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.VehicleResavationDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleResavationDTO;

import java.util.List;

public interface VehicleResavationService {
    void saveResavation(VehicleResavationDTO resavationDTO);

    List<VehicleResavationDTO> getAllResavation(FilterVehicleResavationDTO resavationDTO);
}
