package lk.ijse.GreenShadow.Specification;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleResavationDTO;
import lk.ijse.GreenShadow.entity.Staff;
import lk.ijse.GreenShadow.entity.Vehicle;
import lk.ijse.GreenShadow.entity.VehicleResavation;
import lk.ijse.GreenShadow.util.enums.ResavationType;
import org.springframework.data.jpa.domain.Specification;

public class ResavationSpecification {
    public static Specification<VehicleResavation> createSpecification(FilterVehicleResavationDTO resavationDTO){
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if(resavationDTO.getData() !=null && !resavationDTO.getData().isEmpty()){
                Expression<String> resavationExpression = builder.lower(root.get("resavationId"));
                Expression<String> dateExpression = builder.lower(builder.toString(root.get("date")));
                Expression<String> typeExpression = builder.lower(root.get("resavationType"));
                Expression<String> staffIdExpression = builder.lower(root.get("staff").get("staff_id"));
                Expression<String> vehicleCodeExpression = builder.lower(root.get("vehicle").get("vehicle_code"));
                Expression<String> numberPlateExpression = builder.lower(root.get("license_plate_number"));
                String lowerSearchTerm = resavationDTO.getData().toLowerCase();
                predicate = builder.and(predicate, builder.or(builder.like(resavationExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(dateExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(typeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(staffIdExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(vehicleCodeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(numberPlateExpression,"%" + lowerSearchTerm + "%")
                ));
            }


            if (resavationDTO.getResavationType() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("resavationType"), resavationDTO.getResavationType()));
            }

            assert query != null;
            query.orderBy(builder.desc(root.get("date")));

            return predicate;
        };
    }
}


