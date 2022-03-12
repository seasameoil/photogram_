package photogram.cos.handler.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException{

    //객체 구분할 때 사용
    private static final long serialVersionUID = 1L;

    private Map<String, String> errorMap;

    public CustomValidationException(String message, Map<String, String> errorMap) {
        super(message); //내가 들고 있는 것이 아니라 부모에게 던짐
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}
