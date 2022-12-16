package kyu.pj.transportinformation.topis.routes.data.response.path;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class RoutePathResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private RoutePathResBody<T> msgBody;

    private RoutePathResResult() {}
}
