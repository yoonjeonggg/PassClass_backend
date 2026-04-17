package app_programming_development.Class.exceptions.notFound;

import app_programming_development.Class.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class NotificationNotFoundException extends DomainException {
    public NotificationNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
