package lk.ijse.GreenShadow.Specification;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lk.ijse.GreenShadow.dto.filter.dto.FilterCropDto;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDto;
import lk.ijse.GreenShadow.entity.Crop;
import lk.ijse.GreenShadow.entity.Field;
import org.springframework.data.jpa.domain.Specification;

public class FieldSpecification {
    public static Specification<Field> createSpecification(FilterFieldDto filterFieldDto){
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if(filterFieldDto.getData() !=null && !filterFieldDto.getData().isEmpty()){
                Expression<String> codeExpression = builder.lower(root.get("field_code"));
                Expression<String> commonNameExpression = builder.lower(root.get("field_Name"));
                String lowerSearchTerm = filterFieldDto.getData().toLowerCase();
                predicate = builder.and(predicate, builder.or(builder.like(codeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(commonNameExpression,"%" + lowerSearchTerm + "%")));
            }

            if(filterFieldDto.getFieldSize() !=0.0){
                predicate = builder.and(predicate, builder.equal(root.get("extent_size_of_field"), filterFieldDto.getFieldSize() ));
            }

            assert query != null;
            query.orderBy(builder.desc(root.get("field_code")));

            return predicate;
        };
    }
}
