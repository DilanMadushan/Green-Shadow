package lk.ijse.GreenShadow.dto.filter.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseFilterDto {
    private int page;
    private int perPage;
}