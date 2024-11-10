package lk.ijse.GreenShadow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lk.ijse.GreenShadow.util.enums.ResavationType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class EquipmentDetails {
    @Id
    private String detailId;
    private String date;
    private String resone;
    private ResavationType resavationType;
    @ManyToOne
    @JoinColumn(name = "staff_id",nullable = false)
    private Staff staff;
    @ManyToOne
    @JoinColumn(name = "field_code",nullable = false)
    private Field field;
    @ManyToOne
    @JoinColumn(name = "equipment_Id",nullable = false)
    private Equipment equipment;
}
