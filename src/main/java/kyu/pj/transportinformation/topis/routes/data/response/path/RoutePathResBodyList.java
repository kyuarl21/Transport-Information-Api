package kyu.pj.transportinformation.topis.routes.data.response.path;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/busRouteInfo
 * (EX : http://ws.bus.go.kr/api/rest/busRouteInfo/getRoutePath?busRouteId=xxxxxxx)
 *
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
 *       no	string	순번
 *       gpsX	string	좌표X (WGS84)
 *       gpsY	string	좌표Y (WGS84)
 *       posX	string	좌표X (GRS80)
 *       posY	string	좌표Y (GRS80)
 */
@ToString
@Getter
public class RoutePathResBodyList {

    @JsonProperty("no")
    private String no;

    @JsonProperty("gpsX")
    private String gpsX;

    @JsonProperty("gpsY")
    private String gpsY;

    @JsonProperty("posX")
    private String posX;

    @JsonProperty("posY")
    private String posY;

    private RoutePathResBodyList() {}
}
