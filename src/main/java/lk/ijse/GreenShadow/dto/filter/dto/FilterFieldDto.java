package lk.ijse.GreenShadow.dto.filter.dto;

import lk.ijse.GreenShadow.dto.filter.base.BaseFilterDto;
import lk.ijse.GreenShadow.util.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterFieldDto extends BaseFilterDto {
    private String data;

    public FilterFieldDto( String data, int page, int perPage) {
        super(page, perPage);
        this.data = data;
    }

}
