package lk.ijse.GreenShadow.Specification;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lk.ijse.GreenShadow.dto.filter.dto.FilterCropDTO;
import lk.ijse.GreenShadow.dto.filter.dto.FilterUserDto;
import lk.ijse.GreenShadow.entity.Crop;
import lk.ijse.GreenShadow.entity.User;
import lk.ijse.GreenShadow.util.enums.Role;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<User> createSpecification(FilterUserDto filterUserDto){
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if(filterUserDto.getData() !=null && !filterUserDto.getData().isEmpty()){
                Expression<String> mailExpression = builder.lower(root.get("email"));
                Expression<String> passwordExpression = builder.lower(root.get("password"));
                Expression<String> roleExpression = builder.lower(root.get("role"));
                String lowerSearchTerm = filterUserDto.getData().toLowerCase();
                predicate = builder.and(predicate, builder.or(builder.like(mailExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(passwordExpression,"%" + lowerSearchTerm + "%"),
                        builder.like(roleExpression,"%" + lowerSearchTerm + "%")
                ));
            }

            assert query != null;
            query.orderBy(builder.desc(root.get("email")));

            return predicate;
        };
    }
}
