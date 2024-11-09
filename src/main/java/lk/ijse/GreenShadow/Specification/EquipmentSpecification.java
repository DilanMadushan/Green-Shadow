package lk.ijse.GreenShadow.Specification;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDTO;
import lk.ijse.GreenShadow.entity.Equipment;
import lk.ijse.GreenShadow.entity.EquipmentDetails;
import lk.ijse.GreenShadow.entity.Field;
import lk.ijse.GreenShadow.util.enums.EquipmentStatus;
import lk.ijse.GreenShadow.util.enums.EquipmentType;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class EquipmentSpecification {
    public static Specification<Equipment> createSpecification(FilterEquipmentDTO filterEquipmentDTO){
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if(filterEquipmentDTO.getData() !=null && !filterEquipmentDTO.getData().isEmpty()){
                Expression<String> equipmentIdExpression = builder.lower(root.get("equipment_Id"));
                Expression<String> nameExpression = builder.lower(root.get("name"));
                Expression<String> typeExpression = builder.lower(root.get("type"));
                Expression<String> statusExpression = builder.lower(root.get("status"));
                String lowerSearchTerm = filterEquipmentDTO.getData().toLowerCase();
                predicate = builder.and(predicate, builder.or(builder.like(equipmentIdExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(nameExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(typeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(statusExpression,"%" + lowerSearchTerm + "%")
                ));
            }


            assert query != null;
            query.orderBy(builder.desc(root.get("equipment_Id")));

            return predicate;
        };

    }
}
