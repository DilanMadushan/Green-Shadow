package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepo extends JpaRepository<Field,String> {

}
