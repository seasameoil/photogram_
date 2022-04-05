package photogram.cos.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import photogram.cos.config.auth.PrincipalDetails;
import photogram.cos.handler.ex.CustomValidationException;
import photogram.cos.service.ImageService;
import photogram.cos.web.dto.image.ImageUploadDto;

@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;

    @GetMapping({"/", "/image/story"})
    public String story() {
        return "/image/story";
    }

    @GetMapping("/image/popular")
    public String popular() {
        return "/image/popular";
    }

    @GetMapping("/image/upload")
    public String upload() {
        return "/image/upload";
    }

    @PostMapping("/image")
    public String imageUpload(ImageUploadDto imageUploadDto,
                              @AuthenticationPrincipal PrincipalDetails principalDetails) {

        if(imageUploadDto.getFile().isEmpty()) {
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null);
        }

        imageService.사진업로드(imageUploadDto, principalDetails);
        return "redirect:/user/"+principalDetails.getUser().getId();
    }
}
