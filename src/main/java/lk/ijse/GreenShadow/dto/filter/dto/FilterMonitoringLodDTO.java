package lk.ijse.GreenShadow.dto.filter.dto;

import lk.ijse.GreenShadow.dto.filter.base.BaseFilterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterMonitoringLodDTO extends BaseFilterDTO {
    private String data;
    public FilterMonitoringLodDTO(int page, int perPage, String data) {
        super(page, perPage);
        this.data = data;
    }
}
