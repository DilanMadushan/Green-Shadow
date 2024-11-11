package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.MonitoringLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringLogRepo extends JpaRepository<MonitoringLog,String>, JpaSpecificationExecutor<MonitoringLog> {
}
