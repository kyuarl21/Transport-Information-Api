package kyu.pj.transportinformation.topis.positions.data.response.bystation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/buspos
 * (EX : http://ws.bus.go.kr/api/rest/buspos/getBusPosByRouteSt?busRouteId=xxxxxxxx&startOrd=xx&endOrd=xx)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * busRouteId	string (필수)	노선 ID
 * startOrd	string (필수)	시작 정류소 순번
 * endOrd	string (필수)	종료 정류소 순번
 * 인코딩 방식 (Encoding Type)
 * UTF-8
 *
 * Output
 * XML
 *
 * 출력 결과 필드 (Response Field. Well formed xml)
 * 변수명	타입	설명
 *       sectOrd	string	구간순번
 *       sectDist	string	구간옵셋거리(Km)
 *       stopFlag	string	정류소도착여부 (0:운행중, 1:도착)
 *       sectionId	string	구간 ID
 *       dataTm	string	제공시간
 *       tmX	string	맵매칭X좌표 (WGS84)
 *       tmY	string	맵매칭Y좌표 (WGS84)
 *       vehId	string	버스 ID
 *       plainNo	string	차량번호
 *       busType	string	차량유형 (0:일반버스, 1:저상버스, 2:굴절버스)
 *       lastStnId	string	최종정류장ID
 *       posX	string	맵매칭X좌표 (GRS80)
 *       posY	string	맵매칭Y좌표 (GRS80)
 *       routeId	string	노선 ID
 *       congetion	string	혼잡도 (3 : 여유, 4 : 보통, 5 : 혼잡, 6 : 매우혼잡)
 *       isFullFlag	string	만차여부(0 : 만차아님, 1: 만차)
 */
@ToString
@Getter
public class BusPositionByStationResBodyList {

    @JsonProperty("sectOrd")
    private String sectOrd;

    @JsonProperty("sectDist")
    private String sectDist;

    @JsonProperty("stopFlag")
    private String stopFlag;

    @JsonProperty("sectionId")
    private String sectionId;

    @JsonProperty("dataTm")
    private String dataTm;

    @JsonProperty("tmX")
    private String tmX;

    @JsonProperty("tmY")
    private String tmY;

    @JsonProperty("vehId")
    private String vehId;

    @JsonProperty("plainNo")
    private String plainNo;

    @JsonProperty("busType")
    private String busType;

    @JsonProperty("lastStnId")
    private String lastStnId;

    @JsonProperty("posX")
    private String posX;

    @JsonProperty("posY")
    private String posY;

    @JsonProperty("routeId")
    private String routeId;

    @JsonProperty("congetion")
    private String congetion;

    @JsonProperty("isFullFlag")
    private String isFullFlag;

    private BusPositionByStationResBodyList() {}
}
