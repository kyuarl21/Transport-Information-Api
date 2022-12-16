package kyu.pj.transportinformation.topis.routes.data.response.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/busRouteInfo
 * (EX : http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?strSrch=x)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * strSrch	string (필수)	검색할 노선번호
 * 인코딩 방식 (Encoding Type)
 * UTF-8
 *
 * Output
 * XML
 *
 * 출력 결과 필드 (Response Field. Well formed xml)
 * 변수명	타입	설명
 *       busRouteId	string	노선 ID
 *       busRouteNm	string	노선명 (DB관리용)
 *       busRouteAbrv	string	노선명 (안내용 - 마을버스 제외)
 *       length	string	노선 길이 (Km)
 *       routeType	string	노선 유형 (1:공항, 2:마을, 3:간선, 4:지선, 5:순환, 6:광역, 7:인천, 8:경기, 9:폐지, 0:공용)
 *       stStationNm	string	기점
 *       edStationNm	string	종점
 *       term	string	배차간격 (분)
 *       lastBusYn	string	막차운행여부
 *       firstBusTm	string	금일첫차시간
 *       lastBusTm	string	금일막차시간
 *       firstLowTm	string	금일저상첫차시간
 *       lastLowTm	string	금일저상막차시간
 *       corpNm	string	운수사명
 */
@ToString
@Getter
public class RouteListResponse<T> {

    @JsonProperty("ServiceResult")
    private RouteListResResult<T> serviceResult;

    private RouteListResponse() {}
}
