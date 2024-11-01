package lk.ijse.GreenShadow.dto.filter.dto;

import lk.ijse.GreenShadow.dto.filter.base.BaseFilterDto;
import lk.ijse.GreenShadow.util.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterCropDto extends BaseFilterDto {
    private String data;
    private Category category;

    public FilterCropDto( String data, Category category,int page, int perPage) {
        super(page, perPage);
        this.data = data;
        this.category = category;
    }
}
