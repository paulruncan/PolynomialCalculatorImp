package View;

public interface Validator<T> {
    public void validate(T t) throws Exception;
}
