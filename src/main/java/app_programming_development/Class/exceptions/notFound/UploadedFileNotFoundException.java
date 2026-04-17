package app_programming_development.Class.exceptions.notFound;

import app_programming_development.Class.exceptions.DomainException;
import org.springframework.http.HttpStatus;

public class UploadedFileNotFoundException extends DomainException {
    public UploadedFileNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
