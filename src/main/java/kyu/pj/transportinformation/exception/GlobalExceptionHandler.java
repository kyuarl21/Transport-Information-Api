package kyu.pj.transportinformation.exception;

import kyu.pj.transportinformation.common.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static kyu.pj.transportinformation.common.Status.*;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(value = {RuntimeException.class})
//    protected ResponseEntity<?> handleRuntimeException(RuntimeException e) {
//        log.error("RuntimeException= ", e);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Result(INTERNAL_SERVER_ERROR_CODE, INTERNAL_SERVER_ERROR_MSG));
//    }
//
//    // throw 를 던져도 exception 은 MethodArgumentTypeMismatchException 에서 처리
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<Object> handleConflict(ResponseException e) {
//        e.printStackTrace();
//        return ErrorResponse.toResponseEntityObject(HttpStatus.BAD_REQUEST.value(), INVALID_PARAM_CODE, e.getMessage());
//    }
//
//    @ExceptionHandler(value = {ResponseException.class})
//    protected ResponseEntity<ErrorResult> handleResponseException(ResponseException e) {
//        return ErrorResponse.toResponseEntity(e.getStatus().value(), e.getCode(), e.getMessage());
//    }
//
//    /**
//     * 400 BAD_REQUEST
//     */
//    @ExceptionHandler(value = {BadRequestException.class})
//    protected ResponseEntity<ErrorResult> handleResponseException(BadRequestException e) {
//        return ErrorResponse.toBadRequestEntity(e.getCode(), e.getMessage());
//    }
//
//    /**
//     * 401 UNAUTHORIZED
//     */
//    @ExceptionHandler(value = {UnauthorizedException.class})
//    protected ResponseEntity<ErrorResult> handleResponseException(UnauthorizedException e) {
//        return ErrorResponse.toUnauthorizedEntity(e.getCode(), e.getMessage());
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
//        String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
//        return ErrorResponse.toResponseEntityObject(HttpStatus.BAD_REQUEST.value(), INVALID_PARAM_CODE, message);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
//        // String message = ex.getBindingResult().getFieldErrors().get(0).getField() + "는 " + ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
//        String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
//        return ErrorResponse.toResponseEntityObject(HttpStatus.BAD_REQUEST.value(), INVALID_PARAM_CODE, message);
//    }

    // Handle runtime exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Result> handleRuntimeException(RuntimeException e) {
        log.error("An unexpected error occurred", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Result(INTERNAL_SERVER_ERROR_CODE, INTERNAL_SERVER_ERROR_MSG));
    }

    // Handle method argument type mismatch exception
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Result> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("Method argument type mismatch", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Result(INVALID_PARAM_CODE, INVALID_PARAM_MSG));
    }

    // Handle custom response exceptions
    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<Result> handleResponseException(ResponseException e) {
        return ResponseEntity.status(e.getStatus())
                .body(new Result(e.getCode(), e.getMessage()));
    }

    // Handle bad request exceptions
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Result> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.badRequest()
                .body(new Result(e.getCode(), e.getMessage()));
    }

    // Handle unauthorized exceptions
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Result> handleUnauthorizedException(UnauthorizedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new Result(e.getCode(), e.getMessage()));
    }

    // Handle invalid binding exceptions
//    @Override
//    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
//        String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
//        return ResponseEntity.badRequest()
//                .body(new Result(INVALID_PARAM_CODE, message));
//    }

    // Handle invalid method arguments
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseEntity.badRequest()
                .body(new Result(INVALID_PARAM_CODE, message));
    }
}
