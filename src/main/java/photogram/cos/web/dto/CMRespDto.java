package photogram.cos.web.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMRespDto<T> {

    private int code; //1(성공), -1(실패)
    private String message;
    private T data;

}
