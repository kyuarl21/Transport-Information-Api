package kyu.pj.transportinformation.topis.transfer.data.response.bysubway;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/pathinfo
 * (EX : http://ws.bus.go.kr/api/rest/pathinfo/getPathInfoBySubway?startX=xxxxx&startY=xxxxx&endX=xxxxxx&endY=xxxxxx)
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
 *         routeNm	string	호선명
 *         fid	string	탑승지ID
 *         fname	string	탑승지명
 *         fx	string	탑승지 X좌표 (WGS84)
 *         fy	string	탑승지 Y좌표 (WGS84)
 *         tid	string	하차지ID
 *         tname	string	하차지명
 *         tx	string	하차지 X좌표 (WGS84)
 *         ty	string	하차지 Y좌표 (WGS84)
 *         railLinkList	string	경유지하철역ID목록
 *           railLinkId	string	경유지하철역ID
 */
@ToString
@Getter
public class TransferBySubResBodyList {

    @JsonProperty("distance")
    private String distance;

    @JsonProperty("time")
    private String time;

    @JsonProperty("pathList")
    private String pathList;

    @JsonProperty("routeNm")
    private String routeNm;

    @JsonProperty("fid")
    private String fid;

    @JsonProperty("fname")
    private String fname;

    @JsonProperty("fx")
    private String fx;

    @JsonProperty("fy")
    private String fy;

    @JsonProperty("tid")
    private String tid;

    @JsonProperty("tname")
    private String tname;

    @JsonProperty("tx")
    private String tx;

    @JsonProperty("ty")
    private String ty;

    @JsonProperty("railLinkList")
    private String railLinkList;

    @JsonProperty("railLinkId")
    private String railLinkId;

    private TransferBySubResBodyList() {}
}
