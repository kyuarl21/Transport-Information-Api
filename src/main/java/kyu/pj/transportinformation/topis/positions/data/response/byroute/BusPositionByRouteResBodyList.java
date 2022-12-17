package kyu.pj.transportinformation.topis.positions.data.response.byroute;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/buspos
 * (EX : http://ws.bus.go.kr/api/rest/buspos/getBusPosByRtid?busRouteId=xxxxxxxxx)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * busRouteId	string (필수)	노선 ID
 * 인코딩 방식 (Encoding Type)
 * UTF-8
 *
 * Output
 * XML
 *
 * 출력 결과 필드 (Response Field. Well formed xml)
 * 변수명	타입	설명
 *       sectOrd	string	구간순번
 *       fullSectDist	string	정류소간 거리
 *       sectDist	string	정류장 구간이동거리
 *       rtDist	string	노선옵셋거리 (Km)
 *       stopFlag	string	정류소도착여부 (0:운행중, 1:도착)
 *       sectionId	string	구간ID
 *       dataTm	string	제공시간
 *       gpsX	string	맵매칭X좌표 (WGS84)
 *       gpsY	string	맵매칭Y좌표 (WGS84)
 *       vehId	string	버스 ID
 *       plainNo	string	차량번호
 *       busType	string	차량유형 (0:일반버스, 1:저상버스, 2:굴절버스)
 *       lastStTm	string	종점도착소요시간
 *       nextStTm	string	다음 주요정류소 도착예정시간
 *       nextStId	string	다음 주요정류소ID
 *       isrunyn	string	해당차량 운행여부 (0: 운행종료, 1: 운행)
 *       trnstnid	string	회차지 정류소ID
 *       islastyn	string	막차여부(0 : 막차아님, 1: 막차)
 *       isFullFlag	string	만차여부(0 : 만차아님, 1: 만차)
 *       posX	string	맵매칭X좌표 (GRS80)
 *       posY	string	맵매칭Y좌표 (GRS80)
 *       lastStnId	string	최종정류장 ID
 *       congetion	string	혼잡도 (3 : 여유, 4 : 보통, 5 : 혼잡, 6 : 매우혼잡)
 */
@ToString
@Getter
public class BusPositionByRouteResBodyList {

    @JsonProperty("sectOrd")
    private String sectOrd;

    @JsonProperty("fullSectDist")
    private String fullSectDist;

    @JsonProperty("sectDist")
    private String sectDist;

    @JsonProperty("rtDist")
    private String rtDist;

    @JsonProperty("stopFlag")
    private String stopFlag;

    @JsonProperty("sectionId")
    private String sectionId;

    @JsonProperty("dataTm")
    private String dataTm;

    @JsonProperty("gpsX")
    private String gpsX;

    @JsonProperty("gpsY")
    private String gpsY;

    @JsonProperty("vehId")
    private String vehId;

    @JsonProperty("plainNo")
    private String plainNo;

    @JsonProperty("busType")
    private String busType;

    @JsonProperty("lastStTm")
    private String lastStTm;

    @JsonProperty("nextStTm")
    private String nextStTm;

    @JsonProperty("nextStId")
    private String nextStId;

    @JsonProperty("isrunyn")
    private String isrunyn;

    @JsonProperty("trnstnid")
    private String trnstnid;

    @JsonProperty("islastyn")
    private String islastyn;

    @JsonProperty("isFullFlag")
    private String isFullFlag;

    @JsonProperty("posX")
    private String posX;

    @JsonProperty("posY")
    private String posY;

    @JsonProperty("lastStnId")
    private String lastStnId;

    @JsonProperty("congetion")
    private String congetion;

    private BusPositionByRouteResBodyList() {}
}
