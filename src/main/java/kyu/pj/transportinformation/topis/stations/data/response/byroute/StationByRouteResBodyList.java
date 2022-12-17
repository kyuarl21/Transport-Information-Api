package kyu.pj.transportinformation.topis.stations.data.response.byroute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * busRouteId	string (필수)	노선 시스템 ID
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
 *       seq	string	순번
 *       section	string	구간 ID
 *       station	string	정류소 고유 ID
 *       stationNm	string	정류소 이름
 *       gpsX	string	X좌표 (WGS 84)
 *       gpsY	string	Y좌표 (WGS 84)
 *       direction	string	진행방향
 *       fullSectDist	string	정류소간 거리
 *       stationNo	string	정류소 번호
 *       routeType	string	노선 유형 (1:공항, 2:마을, 3:간선, 4:지선, 5:순환, 6:광역, 7:인천, 8:경기, 9:폐지, 0:공용)
 *       beginTm	string	첫차 시간
 *       lastTm	string	막차 시간
 *       trnstnid	string	회차지 정류소ID
 *       posX	string	좌표X (GRS80)
 *       posY	string	좌표Y (GRS80)
 *       sectSpd	string	구간속도
 *       arsId	string	정류소 고유번호
 *       transYn	string	회차지 여부 (Y:회차, N:회차지아님)
 */
@ToString
@Getter
public class StationByRouteResBodyList {

    @JsonProperty("busRouteId")
    private String busRouteId;

    @JsonProperty("busRouteNm")
    private String busRouteNm;

    @JsonProperty("busRouteAbrv")
    private String busRouteAbrv;

    @JsonProperty("seq")
    private String seq;

    @JsonProperty("section")
    private String section;

    @JsonProperty("station")
    private String station;

    @JsonProperty("stationNm")
    private String stationNm;

    @JsonProperty("gpsX")
    private String gpsX;

    @JsonProperty("gpsY")
    private String gpsY;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("fullSectDist")
    private String fullSectDist;

    @JsonProperty("stationNo")
    private String stationNo;

    @JsonProperty("routeType")
    private String routeType;

    @JsonProperty("beginTm")
    private String beginTm;

    @JsonProperty("lastTm")
    private String lastTm;

    @JsonProperty("trnstnid")
    private String trnstnid;

    @JsonProperty("posX")
    private String posX;

    @JsonProperty("posY")
    private String posY;

    @JsonProperty("sectSpd")
    private String sectSpd;

    @JsonProperty("arsId")
    private String arsId;

    @JsonProperty("transYn")
    private String transYn;

    private StationByRouteResBodyList() {}
}
