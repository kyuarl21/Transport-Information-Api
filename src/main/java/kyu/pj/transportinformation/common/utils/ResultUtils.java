package kyu.pj.transportinformation.common.utils;

import kyu.pj.transportinformation.common.DataResult;
import kyu.pj.transportinformation.common.Result;
import kyu.pj.transportinformation.common.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResultUtils {

    /**
     * HTTP CODE 200
     */
    public static ResponseEntity<Result> resultOk() {
        return ResponseEntity.ok(new Result(Status.SUCCESS_CODE, Status.SUCCESS_MSG));
    }

    /**
     * HTTP CODE 200
     */
    public static <T> ResponseEntity<DataResult<T>> resultOk(T data) {
        return ResponseEntity.ok(new DataResult<T>(Status.SUCCESS_CODE, Status.SUCCESS_MSG, data));
    }

    public static ResponseEntity<Result> resultCreated() {
        return ResponseEntity.status(HttpStatus.CREATED).body(new Result(Status.SUCCESS_CODE, Status.SUCCESS_MSG));
    }
}
