package kyu.pj.transportinformation.topis.routes.data.response.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class RouteInfoResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private RouteInfoResBody<T> msgBody;

    private RouteInfoResResult() {}
}
