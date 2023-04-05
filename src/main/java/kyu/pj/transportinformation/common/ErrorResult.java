package kyu.pj.transportinformation.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResult {

    private int code;
    private String message;
}
