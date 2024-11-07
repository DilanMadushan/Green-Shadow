package lk.ijse.GreenShadow.dto.filter.dto;

import lk.ijse.GreenShadow.dto.filter.base.BaseFilterDto;
import lk.ijse.GreenShadow.util.enums.Designation;
import lk.ijse.GreenShadow.util.enums.Gender;
import lk.ijse.GreenShadow.util.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterStuffDto extends BaseFilterDto {
    private String data;
    private Designation designation;
    private Gender gender;
    private Date joinedDate;
    private Role role;

    public FilterStuffDto(String data, Designation designation, Gender gender, Date joinedDate, Role role,int page, int perPage) {
        super(page, perPage);
        this.data = data;
        this.designation = designation;
        this.gender = gender;
        this.joinedDate = joinedDate;
        this.role = role;
    }

}
