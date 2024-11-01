package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Crop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepo extends JpaRepository<Crop,String>, JpaSpecificationExecutor<Crop> {
    @Query(value = "select crop_code from Crop order by crop_code desc limit 1",nativeQuery = true)
    String lastIndex();

}
