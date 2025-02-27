package springdemo_4.springdemo_4.error;

public class InvalidLoginException extends RuntimeException{
    public InvalidLoginException(String message) {
        super(message);
    }
}
