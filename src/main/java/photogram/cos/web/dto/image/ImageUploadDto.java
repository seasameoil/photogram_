package photogram.cos.web.dto.image;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import photogram.cos.domain.image.Image;
import photogram.cos.domain.user.User;

@Data
public class ImageUploadDto {

    private MultipartFile file;
    private String caption;

    public Image toEntity(String postImageUrl, User user) {
        return Image.builder()
                .caption(caption)
                .postImageUrl(postImageUrl)
                .user(user)
                .build();
    }
}
