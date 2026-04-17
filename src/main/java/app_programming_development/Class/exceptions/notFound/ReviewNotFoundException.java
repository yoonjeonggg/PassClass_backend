package app_programming_development.Class.exceptions.notFound;

import app_programming_development.Class.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class ReviewNotFoundException extends DomainException {
    public ReviewNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
