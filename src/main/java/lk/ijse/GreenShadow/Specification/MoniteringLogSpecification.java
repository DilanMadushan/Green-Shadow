package lk.ijse.GreenShadow.Specification;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lk.ijse.GreenShadow.dto.filter.dto.FilterMonitoringLodDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleResavationDTO;
import lk.ijse.GreenShadow.entity.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class MoniteringLogSpecification {
    public static Specification<MonitoringLog> createSpecification(FilterMonitoringLodDTO filterMonitoringLodDTO){
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if(filterMonitoringLodDTO.getData() !=null && !filterMonitoringLodDTO.getData().isEmpty()){
                Expression<String> codeExpression = builder.lower(root.get("log_code"));
                Expression<String> dateExpression = builder.lower(builder.toString(root.get("log_date")));
                Expression<String> fieldIdExpression = builder.lower(root.get("field").get("field_code"));
                Expression<String> cropCodeExpression = builder.lower(root.get("crop").get("crop_code"));
                Expression<String> staffIdExpression = builder.lower(root.get("staff").get("staff_id"));
                String lowerSearchTerm = filterMonitoringLodDTO.getData().toLowerCase();
                predicate = builder.and(predicate, builder.or(builder.like(codeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(dateExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(fieldIdExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(staffIdExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(cropCodeExpression,"%" + lowerSearchTerm + "%")
                ));
            }


            assert query != null;
            query.orderBy(builder.desc(root.get("log_date")));

            return predicate;
        };

    }
}
