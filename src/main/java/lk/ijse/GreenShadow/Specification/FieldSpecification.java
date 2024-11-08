package lk.ijse.GreenShadow.Specification;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lk.ijse.GreenShadow.dto.filter.dto.FilterFieldDTO;
import lk.ijse.GreenShadow.entity.Field;
import org.springframework.data.jpa.domain.Specification;

public class FieldSpecification {
    public static Specification<Field> createSpecification(FilterFieldDTO filterFieldDto){
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if(filterFieldDto.getData() !=null && !filterFieldDto.getData().isEmpty()){
                Expression<String> codeExpression = builder.lower(root.get("field_code"));
                Expression<String> commonNameExpression = builder.lower(root.get("field_Name"));
                Expression<String> sizeExpression = builder.lower(builder.toString(root.get("extent_size_of_field")));
                String lowerSearchTerm = filterFieldDto.getData().toLowerCase();
                predicate = builder.and(predicate, builder.or(builder.like(codeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(commonNameExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(sizeExpression,"%" + lowerSearchTerm + "%")));
            }


            assert query != null;
            query.orderBy(builder.desc(root.get("field_code")));

            return predicate;
        };
    }
}
