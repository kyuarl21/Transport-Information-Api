package kyu.pj.transportinformation.topis.positions.data.response.bybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BusPositionByBusResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private BusPositionByBusResBody<T> msgBody;

    private BusPositionByBusResResult() {}
}
