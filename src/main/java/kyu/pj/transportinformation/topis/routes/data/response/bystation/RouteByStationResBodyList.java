package kyu.pj.transportinformation.topis.routes.data.response.bystation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/stationinfo
 * (EX : http://ws.bus.go.kr/api/rest/stationinfo/getRouteByStation?arsId=xxxxx)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * arsId	string (필수)	정류소 번호
 * 인코딩 방식 (Encoding Type)
 * UTF-8
 *
 * Output
 * XML
 *
 * 출력 결과 필드 (Response Field. Well formed xml)
 * 변수명	타입	설명
 *       busRouteAbrv	string	노선명 (안내용 - 마을버스 제외)
 *       busRouteId	string	노선ID
 *       busRouteNm	string	노선명 (DB관리용)
 *       length	string	노선길이 (Km)
 *       busRouteType	string	노선유형 (1:공항, 2:마을, 3:간선, 4:지선, 5:순환, 6:광역, 7:인천, 8:경기, 9:폐지, 0:공용)
 *       stBegin	string	기점
 *       stEnd	string	종점
 *       term	string	배차간격 (분)
 *       nextBus	string	막차운행여부 (N:막차아님, Y:막차)
 *       firstBusTm	string	금일첫차시간
 *       lastBusTm	string	금일막차시간
 *       firstBusTmLow	string	금일저상첫차시간
 *       lastBusTmLow	string	금일저상막차시간
 */
@ToString
@Getter
public class RouteByStationResBodyList {

    @JsonProperty("busRouteAbrv")
    private String busRouteAbrv;

    @JsonProperty("busRouteId")
    private String busRouteId;

    @JsonProperty("busRouteNm")
    private String busRouteNm;

    @JsonProperty("length")
    private String length;

    @JsonProperty("busRouteType")
    private String busRouteType;

    @JsonProperty("stBegin")
    private String stBegin;

    @JsonProperty("stEnd")
    private String stEnd;

    @JsonProperty("term")
    private String term;

    @JsonProperty("nextBus")
    private String nextBus;

    @JsonProperty("firstBusTm")
    private String firstBusTm;

    @JsonProperty("lastBusTm")
    private String lastBusTm;

    @JsonProperty("firstBusTmLow")
    private String firstBusTmLow;

    @JsonProperty("lastBusTmLow")
    private String lastBusTmLow;

    private RouteByStationResBodyList() {}
}
