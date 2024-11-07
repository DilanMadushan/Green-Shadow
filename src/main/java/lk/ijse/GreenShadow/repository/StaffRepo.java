package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<Staff,String> , JpaSpecificationExecutor<Staff> {
    @Query(value = "select staff_id from staff order by staff_id desc limit 1",nativeQuery = true)
    String findLastIndex();
}
