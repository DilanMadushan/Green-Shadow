package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.EquipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDetailsRepo extends JpaRepository<EquipmentDetails,String>, JpaSpecificationExecutor<EquipmentDetails> {
}
