package lk.ijse.GreenShadow.service;

import lk.ijse.GreenShadow.dto.MonitoringLogDTO;

import java.util.List;

public interface MonitoringLogService {
    void saveMonitoringLogDetail(MonitoringLogDTO monitoringLogDTO);
    void updateMonitoringLogDetail(MonitoringLogDTO monitoringLogDTO);
    void deleteMonitoringLogDetail(String id);
    List<MonitoringLogDTO> getAllMonitoringLog();
    String findLastIndex();
}
