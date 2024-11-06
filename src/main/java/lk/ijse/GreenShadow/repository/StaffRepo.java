package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<Staff,String> {
}
