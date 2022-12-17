package kyu.pj.transportinformation.topis.positions.data.response.byroute;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BusPositionByRouteResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private BusPositionByRouteResBody<T> msgBody;

    private BusPositionByRouteResResult() {}
}
