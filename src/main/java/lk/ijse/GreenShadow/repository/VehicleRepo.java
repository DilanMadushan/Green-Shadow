package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,String>, JpaSpecificationExecutor<Vehicle> {
    @Query(value = "select vehicle_code from vehicle order by vehicle_code desc limit 1;",nativeQuery = true)
    String findLastIndex();
}
