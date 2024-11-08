package lk.ijse.GreenShadow.entity;

import jakarta.persistence.*;
import lk.ijse.GreenShadow.util.enums.EquipmentStatus;
import lk.ijse.GreenShadow.util.enums.EquipmentType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "EQUIPMENT")
public class Equipment {
    @Id
    private String equipment_Id;
    private String name;
    @Enumerated(EnumType.STRING)
    private EquipmentType type;
    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;
    @OneToOne
    @JoinColumn(name = "staff_id",nullable = false)
    private Staff staff_id;
    @OneToOne
    @JoinColumn(name = "field_code",nullable = false)
    private Field field_code;
}
