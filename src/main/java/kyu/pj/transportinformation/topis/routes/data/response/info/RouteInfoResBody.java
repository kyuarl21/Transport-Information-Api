package kyu.pj.transportinformation.topis.routes.data.response.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class RouteInfoResBody<T> {

    @JsonProperty("itemList")
    private RouteInfoResBodyMap<T> itemList;

    private RouteInfoResBody() {}
}
