package kyu.pj.transportinformation.topis.transfer.data.response.busnsub;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/pathinfo
 * (EX : http://ws.bus.go.kr/api/rest/pathinfo/getPathInfoByBusNSub?startX=xxxxx&startY=xxxxx&endX=xxxxxx&endY=xxxxxx)
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
 *       pathList	string	경로목록
 *       railLinkId	string	경유지하철역ID목록
 *       tx	string	하차지 X좌표 (WGS84)
 *       ty	string	하차지 Y좌표 (WGS84)
 *       time	string	소요시간
 *       fid	string	탑승지 ID
 *       fname	string	탑승지명
 *       fx	string	탑승지 X좌표 (WGS84)
 *       fy	string	탑승지 Y좌표 (WGS84)
 *       routeId	string	노선 ID
 *       routeNm	string	노선명
 *       tid	string	하차지 ID
 *       tname	string	하차지명
 *       isFullFlag	string	만차여부(0 : 만차아님, 1: 만차)
 *       congetion	string	혼잡도 (3 : 여유, 4 : 보통, 5 : 혼잡, 6 : 매우혼잡)
 *       stId	string	정류장 ID
 */
@ToString
@Getter
public class TransferBusNSubResponse<T> {

    @JsonProperty("ServiceResult")
    private TransferBusNSubResResult<T> serviceResult;

    private TransferBusNSubResponse() {}
}
