package kyu.pj.transportinformation.topis.routes.data.response.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class RouteListResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private RouteListResBody<T> msgBody;

    private RouteListResResult() {}
}
