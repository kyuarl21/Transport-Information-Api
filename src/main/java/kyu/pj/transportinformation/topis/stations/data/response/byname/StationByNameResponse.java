package kyu.pj.transportinformation.topis.stations.data.response.byname;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/stationinfo
 * (EX : http://ws.bus.go.kr/api/rest/stationinfo/getStationByName?stSrch=xxxxxxxxxxxxxxxx)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * stSrch	string (필수)	정류소명 검색어
 * **한글은 URL Encoding을 거쳐서 보내야 합니다.
 * 인코딩 방식 (Encoding Type)
 * UTF-8
 *
 * Output
 * XML
 *
 * 출력 결과 필드 (Response Field. Well formed xml)
 * 변수명	타입	설명
 *       stId	string	정류소 고유 ID
 *       stNm	string	정류소명
 *       tmX	string	정류소 좌표X (WGS84)
 *       tmY	string	정류소 좌표Y (WGS84)
 *       arsId	string	정류소 번호
 *       posX	string	정류소 좌표X (GRS80)
 *       posY	string	정류소 좌표Y (GRS80)
 */
@ToString
@Getter
public class StationByNameResponse<T> {

    @JsonProperty("ServiceResult")
    private StationByNameResResult<T> serviceResult;

    private StationByNameResponse() {}
}
