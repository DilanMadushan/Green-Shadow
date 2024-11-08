package lk.ijse.GreenShadow.Specification;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lk.ijse.GreenShadow.dto.filter.dto.FilterStuffDTO;
import lk.ijse.GreenShadow.entity.Staff;
import org.springframework.data.jpa.domain.Specification;


public class StaffSpecification {
    public static Specification<Staff> createSpecification(FilterStuffDTO filterStuffDto){
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if(filterStuffDto.getData() !=null && !filterStuffDto.getData().isEmpty()){
                Expression<String> firstNameExpression = builder.lower(root.get("first_name"));
                Expression<String> lastNameExpression = builder.lower(root.get("last_name"));
                Expression<String> designationExpression = builder.lower(root.get("designation"));
                Expression<String> gennderExpression = builder.lower(root.get("gender"));
                Expression<String> dateExpression = builder.lower(builder.toString(root.get("joinedDate")));
                Expression<String> dobExpression = builder.lower(builder.toString(root.get("dob")));
                Expression<String> addressLine1Expression = builder.lower(root.get("address_line_1"));
                Expression<String> addressLine2Expression = builder.lower(root.get("address_line_2"));
                Expression<String> addressLine3Expression = builder.lower(root.get("address_line_3"));
                Expression<String> addressLine4Expression = builder.lower(root.get("address_line_4"));
                Expression<String> addressLine5Expression = builder.lower(root.get("address_line_5"));
                Expression<String> emailExpression = builder.lower(root.get("email"));
                Expression<String> telExpression = builder.lower(root.get("tel"));
                Expression<String> roleExpression = builder.lower(root.get("role"));
                String lowerSearchTerm = filterStuffDto.getData().toLowerCase();
                predicate = builder.and(predicate, builder.or(builder.like(firstNameExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(lastNameExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(designationExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(gennderExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(dateExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(dobExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(addressLine1Expression,"%" + lowerSearchTerm + "%"),
                        builder.like(addressLine2Expression,"%" + lowerSearchTerm + "%"),
                        builder.like(addressLine3Expression,"%" + lowerSearchTerm + "%"),
                        builder.like(addressLine4Expression,"%" + lowerSearchTerm + "%"),
                        builder.like(addressLine5Expression,"%" + lowerSearchTerm + "%"),
                        builder.like(emailExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(telExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(roleExpression,"%" + lowerSearchTerm + "%")
                ));
            }


            assert query != null;
            query.orderBy(builder.desc(root.get("staff_id")));

            return predicate;
        };
    }
}

