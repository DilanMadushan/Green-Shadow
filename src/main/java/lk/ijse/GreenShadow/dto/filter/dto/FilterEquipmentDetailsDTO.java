package lk.ijse.GreenShadow.dto.filter.dto;

import lk.ijse.GreenShadow.dto.filter.base.BaseFilterDTO;
import lk.ijse.GreenShadow.util.enums.ResavationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterEquipmentDetailsDTO extends BaseFilterDTO {

    private String data;
    private ResavationType resavationType;

    public FilterEquipmentDetailsDTO( String data,ResavationType resavationType,int page, int perPage) {
        super(page, perPage);
        this.data = data;
        this.resavationType=resavationType;
    }

}
