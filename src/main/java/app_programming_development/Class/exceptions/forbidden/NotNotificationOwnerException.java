package app_programming_development.Class.exceptions.forbidden;

import app_programming_development.Class.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class NotNotificationOwnerException extends DomainException {
    public NotNotificationOwnerException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
