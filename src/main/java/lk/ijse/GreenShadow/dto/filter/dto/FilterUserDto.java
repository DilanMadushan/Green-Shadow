package lk.ijse.GreenShadow.dto.filter.dto;

import lk.ijse.GreenShadow.dto.filter.base.BaseFilterDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterUserDto extends BaseFilterDTO {
    private String data;

    public FilterUserDto(String data, int page, int perPage) {
        super(page, perPage);
        this.data = data;
    }

}
