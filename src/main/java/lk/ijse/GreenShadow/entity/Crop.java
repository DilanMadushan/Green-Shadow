package lk.ijse.GreenShadow.entity;

import jakarta.persistence.*;
import lk.ijse.GreenShadow.util.enums.Category;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "CROP")
public class Crop {
    @Id
    private String crop_code;
    private String common_name;
    private String scientific_name;
    @Column(columnDefinition = "LONGTEXT")
    private String crop_image;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String crop_season;
    @ManyToOne
    @JoinColumn(name = "field_code")
    private Field field;
    @OneToMany(mappedBy = "crops")
    private List<MonitoringLog> logs;

}
