package photogram.cos.handler.ex;

public class CustomException extends RuntimeException{

    //객체 구분할 때 사용
    private static final long serialVersionUID = 1L;

    public CustomException(String message) {
        super(message); //내가 들고 있는 것이 아니라 부모에게 던짐
    }
}
