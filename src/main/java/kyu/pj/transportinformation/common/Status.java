package kyu.pj.transportinformation.common;

public class Status {

    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MSG = "성공";

    public static final int FAIL_CODE = 1;
    public static final String FAIL_MSG = "실패";

    public static final int INVALID_PARAM_CODE = 2;
    public static final String INVALID_PARAM_MSG = "잘못된 파라미터 입니다.";



    public static final int NO_CONTENT_CODE = -204;
    public static final String NO_CONTENT_MSG = "결과가 없습니다.";



    public static final int BAD_REQUEST_CODE = -400;
    public static final String BAD_REQUEST_MSG = "잘못된 요청입니다.";

    public static final int UNAUTHORIZED_CODE = -401;
    public static final String UNAUTHORIZED_MSG = "인증이 필요합니다.";

    public static final int FORBIDDEN_CODE = -403;
    public static final String FORBIDDEN_MSG = "권한이 없습니다.";



    public static final int INTERNAL_SERVER_ERROR_CODE = -500;
    public static final String INTERNAL_SERVER_ERROR_MSG = "서버 오류로 현재 이용이 불가능 합니다.";
}
