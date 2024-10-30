package lk.ijse.GreenShadow.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
@Component
public class ImageConvater {
    public String imageToBase65(MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public MultipartFile imageToBase65(String image) throws IOException {
        byte[] decode = Base64.getDecoder().decode(image);


    }
}
