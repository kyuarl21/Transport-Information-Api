package kyu.pj.transportinformation.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Result {
    // 응답 코드 : 0일 경우 성공, 이외의 모든 경우 실패
    private int code;

    // 응답 메세지
    private String message;
}
