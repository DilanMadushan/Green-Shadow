package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Vehicle;
import lk.ijse.GreenShadow.entity.VehicleResavation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehicleResavationRepo extends JpaRepository<VehicleResavation,String> , JpaSpecificationExecutor<VehicleResavation> {
}
