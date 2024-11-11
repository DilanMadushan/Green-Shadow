package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.MonitoringLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringLogRepo extends JpaRepository<MonitoringLog,String>, JpaSpecificationExecutor<MonitoringLog> {
    @Query(value = "select log_code from moniteringlog order by log_code desc limit 1",nativeQuery = true)
    String findLastIndex();
}
