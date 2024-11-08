package lk.ijse.GreenShadow.dto.filter.dto;

import lk.ijse.GreenShadow.dto.filter.base.BaseFilterDTO;
import lk.ijse.GreenShadow.util.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterCropDTO extends BaseFilterDTO {
    private String data;
    private Category category;

    public FilterCropDTO(String data, Category category, int page, int perPage) {
        super(page, perPage);
        this.data = data;
        this.category = category;
    }
}
