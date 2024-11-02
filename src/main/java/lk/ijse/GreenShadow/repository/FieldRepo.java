package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepo extends JpaRepository<Field,String> , JpaSpecificationExecutor<Field>{

    @Query(value = "select field_code from Field order by field_code desc limit 1 ",nativeQuery = true)
    String getLastIndex();
}
