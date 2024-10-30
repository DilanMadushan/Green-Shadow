package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepo extends JpaRepository<Crop,String> {
}
