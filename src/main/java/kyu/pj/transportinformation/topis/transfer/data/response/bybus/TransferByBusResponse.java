package kyu.pj.transportinformation.topis.transfer.data.response.bybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/pathinfo
 * (EX : http://ws.bus.go.kr/api/rest/pathinfo/getPathInfoByBus?startX=xxxxx&startY=xxxxx&endX=xxxxxx&endY=xxxxxx)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * startX	string (필수)	시작점 X 좌표 (WGS84)
 * startY	string (필수)	시작점 Y 좌표 (WGS84)
 * endX	string (필수)	도착점 X 좌표 (WGS84)
 * endY	string (필수)	도착점 Y 좌표 (WGS84)
 * 인코딩 방식 (Encoding Type)
 * UTF-8
 *
 * Output
 * XML
 *
 * 출력 결과 필드 (Response Field. Well formed xml)
 * 변수명	타입	설명
 *       distance	string	거리
 *       time	string	소요시간
 *       pathList	string	경로목록
 *         routeId	string	노선ID
 *         routeNm	string	노선명
 *         fid	string	탑승지ID
 *         fname	string	탑승지명
 *         fx	string	탑승지 X좌표 (WGS84)
 *         fy	string	탑승지 Y좌표 (WGS84)
 *         tid	string	하차지ID
 *         tname	string	하차지명
 *         tx	string	하차지 X좌표 (WGS84)
 *         ty	string	하차지 Y좌표 (WGS84)
 */
@ToString
@Getter
public class TransferByBusResponse<T> {

    @JsonProperty("ServiceResult")
    private TransferByBusResResult<T> serviceResult;

    private TransferByBusResponse() {}
}
