package kyu.pj.transportinformation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ResponseException extends RuntimeException {

    private HttpStatus status;
    private int code;
    private String message;
}
