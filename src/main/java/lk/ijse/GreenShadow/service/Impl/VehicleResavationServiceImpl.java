package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.dto.VehicleDTO;
import lk.ijse.GreenShadow.dto.VehicleResavationDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleDTO;
import lk.ijse.GreenShadow.repository.VehicleResavationRepo;
import lk.ijse.GreenShadow.service.VehicleResavationService;
import lk.ijse.GreenShadow.service.VehicleService;
import lk.ijse.GreenShadow.util.enums.ResavationType;
import lk.ijse.GreenShadow.util.enums.Status;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class VehicleResavationServiceImpl implements VehicleResavationService {
    private final VehicleResavationRepo vehicleResavationRepo;
    private final VehicleService vehicleService;
    private final Map map;

    @Override
    public void saveResavation(VehicleResavationDTO resavationDTO) {
        if (vehicleResavationRepo.existsById(resavationDTO.getResavationId()))throw new AlradyExsistException("Resavation Alrady Exsist");
        vehicleResavationRepo.save(map.toVehicleResavationEntity(resavationDTO));
        if(resavationDTO.getType() == ResavationType.Pickup){
            vehicleService.updateStatus(resavationDTO.getVehicle_code(), Status.UNAVAILABLE);
        }else{
            vehicleService.updateStatus(resavationDTO.getVehicle_code(),Status.AVAILABLE);
        }
    }
}
