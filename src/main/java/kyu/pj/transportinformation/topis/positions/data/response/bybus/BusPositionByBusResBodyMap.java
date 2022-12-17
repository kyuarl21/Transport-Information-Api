package kyu.pj.transportinformation.topis.positions.data.response.bybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/buspos
 * (EX : http://ws.bus.go.kr/api/rest/buspos/getBusPosByVehId?vehId=xxxxxxx)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * vehId	string (필수)	버스 ID
 * 인코딩 방식 (Encoding Type)
 * UTF-8
 *
 * Output
 * XML
 *
 * 출력 결과 필드 (Response Field. Well formed xml)
 * 변수명	타입	설명
 *       vehId	string	버스ID
 *       stId	string	정류소 고유 ID
 *       stOrd	string	정류소순번
 *       stopFlag	string	정류소도착여부 (0:운행중, 1:도착)
 *       dataTm	string	제공시간
 *       tmX	string	맵매칭X좌표 (WGS84)
 *       tmY	string	맵매칭Y좌표 (WGS84)
 *       plainNo	string	차량번호
 *       busType	string	차량유형 (0:일반버스, 1:저상버스, 2:굴절버스)
 *       lastStnId	string	최종정류장 ID
 *       posX	string	맵매칭X좌표 (GRS80)
 *       posY	string	맵매칭Y좌표 (GRS80)
 *       congetion	string	혼잡도 (3 : 여유, 4 : 보통, 5 : 혼잡, 6 : 매우혼잡)
 */
@ToString
@Getter
public class BusPositionByBusResBodyMap<T> {

    @JsonProperty("vehId")
    private String vehId;

    @JsonProperty("stId")
    private String stId;

    @JsonProperty("stOrd")
    private String stOrd;

    @JsonProperty("stopFlag")
    private String stopFlag;

    @JsonProperty("dataTm")
    private String dataTm;

    @JsonProperty("tmX")
    private String tmX;

    @JsonProperty("tmY")
    private String tmY;

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

    @JsonProperty("congetion")
    private String congetion;

    private BusPositionByBusResBodyMap() {}
}
