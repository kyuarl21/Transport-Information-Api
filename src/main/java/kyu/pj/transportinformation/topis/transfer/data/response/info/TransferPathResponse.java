package kyu.pj.transportinformation.topis.transfer.data.response.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 URL (Request Url)
 * http://ws.bus.go.kr/api/rest/pathinfo
 * (EX : http://ws.bus.go.kr/api/rest/pathinfo/getLocationInfo?stSrch=XXXXXXXX)
 *
 * 요청 변수 (Request Parameter)
 * 변수명	타입	설명
 * serviceKey	string (필수)	발급받은 키 값
 * stSrch	string (필수)	정류장명
 * 인코딩 방식 (Encoding Type)
 * UTF-8
 *
 * Output
 * XML
 *
 * 출력 결과 필드 (Response Field. Well formed xml)
 * 변수명	타입	설명
 *       poiId	string	POI ID
 *       poiNm	string	POI 이름
 *       gpsX	string	X좌표 (WGS84)
 *       gpsY	string	Y좌표 (WGS84)
 *       posX	string	X좌표 (GRS80)
 *       posY	string	Y좌표 (GRS80)
 *       addr	string	주소 (옵션)
 */
@ToString
@Getter
public class TransferPathResponse<T> {

    @JsonProperty("ServiceResult")
    private TransferPathResResult<T> serviceResult;

    private TransferPathResponse() {}
}
