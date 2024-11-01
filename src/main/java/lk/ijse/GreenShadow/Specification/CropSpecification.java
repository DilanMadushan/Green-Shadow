package lk.ijse.GreenShadow.Specification;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lk.ijse.GreenShadow.dto.filter.dto.FilterCropDto;
import lk.ijse.GreenShadow.entity.Crop;
import org.springframework.data.jpa.domain.Specification;


public class CropSpecification {
    public static Specification<Crop> createSpecification(FilterCropDto filterCropDto){
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if(filterCropDto.getData() !=null && !filterCropDto.getData().isEmpty()){
                Expression<String> codeExpression = builder.lower(root.get("crop_code"));
                Expression<String> commonNameExpression = builder.lower(root.get("common_name"));
                Expression<String> scientificNameExpression = builder.lower(root.get("scientific_name"));
                String lowerSearchTerm = filterCropDto.getData().toLowerCase();
                predicate = builder.and(predicate, builder.or(builder.like(codeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(commonNameExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(scientificNameExpression,"%" + lowerSearchTerm + "%")));
            }

            if(filterCropDto.getCategory() !=null){
                predicate = builder.and(predicate, builder.equal(root.get("category"), filterCropDto.getCategory()));
            }

            assert query != null;
            query.orderBy(builder.desc(root.get("crop_code")));

            return predicate;
        };
    }

}
