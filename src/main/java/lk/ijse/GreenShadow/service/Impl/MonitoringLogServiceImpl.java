package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.dto.MonitoringLogDTO;
import lk.ijse.GreenShadow.repository.MonitoringLogRepo;
import lk.ijse.GreenShadow.service.MonitoringLogService;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class MonitoringLogServiceImpl implements MonitoringLogService {
    private final MonitoringLogRepo monitoringLogRepo;
    private final Map map;
    @Override
    public void saveMonitoringLogDetail(MonitoringLogDTO monitoringLogDTO) {
        if (monitoringLogRepo.existsById(monitoringLogDTO.getLog_code())) throw new AlradyExsistException("Log IS Alrady exsist");
        monitoringLogRepo.save(map.toMonitiringLogEntity(monitoringLogDTO));
    }

    @Override
    public void UpdateMonitoringLogDetail(MonitoringLogDTO monitoringLogDTO) {

    }

    @Override
    public void deleteMonitoringLogDetail(String id) {

    }

    @Override
    public List<MonitoringLogDTO> getAllMonitoringLog() {
        return null;
    }

    @Override
    public String findLastIndex() {
        return null;
    }
}
