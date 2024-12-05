package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Vehicle;
import lk.ijse.GreenShadow.entity.VehicleResavation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface VehicleResavationRepo extends JpaRepository<VehicleResavation,String> , JpaSpecificationExecutor<VehicleResavation> {
    @Query(value = "select resavation_id from vehicle_resavation order by resavation_id desc  limit 1",nativeQuery = true)
    String findLastIndex();
}
