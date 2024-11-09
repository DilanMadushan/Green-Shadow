package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment,String>, JpaSpecificationExecutor<Equipment> {
    @Query(value = "select equipment_id from equipment order by equipment_id desc limit 1",nativeQuery = true)
    String findLastIndex();
}
