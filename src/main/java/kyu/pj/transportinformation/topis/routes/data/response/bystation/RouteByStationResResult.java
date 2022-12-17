package kyu.pj.transportinformation.topis.routes.data.response.bystation;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class RouteByStationResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private RouteByStationResBody<T> msgBody;

    private RouteByStationResResult() {}
}
