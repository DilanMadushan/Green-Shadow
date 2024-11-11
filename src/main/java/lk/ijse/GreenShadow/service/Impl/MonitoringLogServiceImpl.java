package lk.ijse.GreenShadow.service.Impl;

import lk.ijse.GreenShadow.Specification.MoniteringLogSpecification;
import lk.ijse.GreenShadow.Specification.ResavationSpecification;
import lk.ijse.GreenShadow.dto.MonitoringLogDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterMonitoringLodDTO;
import lk.ijse.GreenShadow.entity.MonitoringLog;
import lk.ijse.GreenShadow.entity.VehicleResavation;
import lk.ijse.GreenShadow.repository.MonitoringLogRepo;
import lk.ijse.GreenShadow.service.MonitoringLogService;
import lk.ijse.GreenShadow.util.Convater.Convater;
import lk.ijse.GreenShadow.util.exception.AlradyExsistException;
import lk.ijse.GreenShadow.util.exception.NotFoundException;
import lk.ijse.GreenShadow.util.map.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class MonitoringLogServiceImpl implements MonitoringLogService {
    private final MonitoringLogRepo monitoringLogRepo;
    private final Map map;
    private final Convater convater;
    @Override
    public void saveMonitoringLogDetail(MonitoringLogDTO monitoringLogDTO) {
        if (monitoringLogRepo.existsById(monitoringLogDTO.getLog_code())) throw new AlradyExsistException("Log IS Alrady exsist");
        monitoringLogRepo.save(map.toMonitiringLogEntity(monitoringLogDTO));
    }

    @Override
    public void updateMonitoringLogDetail(MonitoringLogDTO monitoringLogDTO) {
        MonitoringLog found = monitoringLogRepo.findById(monitoringLogDTO.getLog_code()).orElseThrow(() -> new NotFoundException("Log Not Found"));
        MonitoringLog update = map.toMonitiringLogEntity(monitoringLogDTO);
        convater.convertMonitoringLog(found,update);
    }

    @Override
    public void deleteMonitoringLogDetail(String id) {
        monitoringLogRepo.findById(id).orElseThrow(()-> new NotFoundException("log Not Found"));
        monitoringLogRepo.deleteById(id);
    }

    @Override
    public List<MonitoringLogDTO> getAllMonitoringLog(FilterMonitoringLodDTO filterMonitoringLodDTO) {
        Pageable pageable = PageRequest.of(filterMonitoringLodDTO.getPage(), filterMonitoringLodDTO.getPerPage());
        Specification<MonitoringLog> specification = MoniteringLogSpecification.createSpecification(filterMonitoringLodDTO);

        Page<MonitoringLog> resualt = monitoringLogRepo.findAll(specification, pageable);
        List<MonitoringLogDTO> logs = new ArrayList<>();

        for (MonitoringLog monitoringLog : resualt) {
            logs.add(map.toMonitiringLogDto(monitoringLog));
        }
        return logs;
    }

    @Override
    public String findLastIndex() {
        return null;
    }
}
