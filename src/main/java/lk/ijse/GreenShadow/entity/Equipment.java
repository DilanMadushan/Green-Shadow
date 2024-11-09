package lk.ijse.GreenShadow.entity;

import jakarta.persistence.*;
import lk.ijse.GreenShadow.util.enums.EquipmentStatus;
import lk.ijse.GreenShadow.util.enums.EquipmentType;
import lombok.*;

import java.util.List;

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
    @OneToMany(mappedBy = "equipment")
    private List<EquipmentDetails> equipmentDetails;
}
