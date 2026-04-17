package app_programming_development.Class.exceptions.conflict;

import app_programming_development.Class.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class DuplicateReviewException extends DomainException {
    public DuplicateReviewException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
