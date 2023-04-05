package kyu.pj.transportinformation.exception;

import kyu.pj.transportinformation.common.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse {

    public static ResponseEntity<ErrorResult> toResponseEntity(int status, int code, String message) {
        return ResponseEntity.status(status).body(new ErrorResult(code, message));
    }

    public static ResponseEntity<Object> toResponseEntityObject(int status, int code, String message) {
        return ResponseEntity.status(status).body(new ErrorResult(code, message));
    }

    public static ResponseEntity<ErrorResult> toBadRequestEntity(int code, String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResult(code, message));
    }

    public static ResponseEntity<ErrorResult> toUnauthorizedEntity(int code, String message) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResult(code, message));
    }
}
