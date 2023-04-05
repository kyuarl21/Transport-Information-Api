package kyu.pj.transportinformation.common.utils;

import kyu.pj.transportinformation.common.DataResult;
import kyu.pj.transportinformation.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static kyu.pj.transportinformation.common.Status.*;

public class ResultUtils {

    /**
     * HTTP CODE 200
     */
    public static ResponseEntity<Result> resultOk() {
        return ResponseEntity.ok(new Result(SUCCESS_CODE, SUCCESS_MSG));
    }

    /**
     * HTTP CODE 200
     */
    public static <T> ResponseEntity<DataResult<T>> resultOk(T data) {
        return ResponseEntity.ok(new DataResult<T>(SUCCESS_CODE, SUCCESS_MSG, data));
    }

    /**
     * HTTP CODE 201
     */
    public static ResponseEntity<Result> resultCreated() {
        return ResponseEntity.status(HttpStatus.CREATED).body(new Result(SUCCESS_CODE, SUCCESS_MSG));
    }
}
