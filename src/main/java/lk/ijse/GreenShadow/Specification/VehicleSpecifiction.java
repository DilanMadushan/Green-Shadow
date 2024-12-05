package lk.ijse.GreenShadow.Specification;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lk.ijse.GreenShadow.dto.filter.dto.FilterStuffDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterVehicleDTO;
import lk.ijse.GreenShadow.entity.Staff;
import lk.ijse.GreenShadow.entity.Vehicle;
import org.springframework.data.jpa.domain.Specification;

public class VehicleSpecifiction {
    public static Specification<Vehicle> createSpecification(FilterVehicleDTO filterVehicleDTO){
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if(filterVehicleDTO.getData() !=null && !filterVehicleDTO.getData().isEmpty()){
                Expression<String> vehicleCodeExpression = builder.lower(root.get("vehicle_code"));
                Expression<String> licensePlateNumberExpression = builder.lower(root.get("license_plate_number"));
                Expression<String> categoryExpression = builder.lower(root.get("vehicle_category"));
                Expression<String> fuelTypeExpression = builder.lower(root.get("fuel_type"));
                Expression<String> statusExpression = builder.lower(root.get("status"));
                Expression<String> remarksExpression = builder.lower(root.get("remarks"));
                String lowerSearchTerm = filterVehicleDTO.getData().toLowerCase();
                predicate = builder.and(predicate, builder.or(builder.like(vehicleCodeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(licensePlateNumberExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(categoryExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(fuelTypeExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(statusExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(remarksExpression,"%" + lowerSearchTerm + "%")
                ));
            }


            assert query != null;
            query.orderBy(builder.asc(root.get("vehicle_code")));

            return predicate;
        };
    }

}
