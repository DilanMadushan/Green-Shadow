package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepo extends JpaRepository<Crop,String> {
    @Query(value = "select crop_code from Crop order by crop_code desc limit 1",nativeQuery = true)
    String lastIndex();
}
