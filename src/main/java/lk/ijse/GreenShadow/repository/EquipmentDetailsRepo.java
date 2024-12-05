package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.EquipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDetailsRepo extends JpaRepository<EquipmentDetails,String>, JpaSpecificationExecutor<EquipmentDetails> {
    @Query(value = "select detail_id from equipment_details order by detail_id desc limit 1",nativeQuery = true)
    String findLastIndex();
}
