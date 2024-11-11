package lk.ijse.GreenShadow.Specification;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lk.ijse.GreenShadow.dto.filter.dto.FilterEquipmentDetailsDTO;
import lk.ijse.GreenShadow.entity.*;
import org.springframework.data.jpa.domain.Specification;

public class EquipmentDetailsSpecification {
    public static Specification<EquipmentDetails> createSpecification(FilterEquipmentDetailsDTO filterEquipmentDetailsDTO){
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if(filterEquipmentDetailsDTO.getData() !=null && !filterEquipmentDetailsDTO.getData().isEmpty()){
                Expression<String> detailIdExpression = builder.lower(root.get("detailId"));
                Expression<String> dateExpression = builder.lower(builder.toString(root.get("date")));
                Expression<String> typeExpression = builder.lower(root.get("resavationType"));
                Expression<String> staffIdExpression = builder.lower(root.get("staff").get("staff_id"));
                Expression<String> fieldCodeExpression = builder.lower(root.get("field").get("field_code"));
                Expression<String> equipmentIdCodeExpression = builder.lower(root.get("equipment").get("equipment_Id"));
                String lowerSearchTerm = filterEquipmentDetailsDTO.getData().toLowerCase();
                predicate = builder.and(predicate, builder.or(builder.like(detailIdExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(dateExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(typeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(staffIdExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(fieldCodeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(equipmentIdCodeExpression,"%" + lowerSearchTerm + "%")
                ));
            }


            if (filterEquipmentDetailsDTO.getResavationType() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("resavationType"), filterEquipmentDetailsDTO.getResavationType()));
            }

            assert query != null;
            query.orderBy(builder.desc(root.get("date")));

            return predicate;
        };
    }
}
