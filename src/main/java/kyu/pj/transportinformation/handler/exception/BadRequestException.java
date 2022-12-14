package kyu.pj.transportinformation.handler.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BadRequestException extends RuntimeException {

    private int code;
    private String message;
}
