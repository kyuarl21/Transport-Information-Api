package kyu.pj.transportinformation.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataResult<T> {
    // 응답 코드 : 0일 경우 성공, 이외의 모든 경우 실패
    private int code;

    // 응답 메세지
    private String message;

    // 데이터 JSON
    private T data;
}
