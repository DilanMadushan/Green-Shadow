package lk.ijse.GreenShadow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "FIELD")
public class Field {
    @Id
    private String field_code;
    private String field_Name;
    private String field_location;
    private double extent_size_of_field;
    @OneToMany(mappedBy = "field")
    private List<Crop> crops;
    @OneToMany(mappedBy = "field" )
    private List<MonitoringLog> log;
    @Column(columnDefinition = "LONGTEXT")
    private String field_image_1;
    @Column(columnDefinition = "LONGTEXT")
    private String field_image_2;
}
