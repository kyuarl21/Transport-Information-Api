package kyu.pj.transportinformation.topis.routes.data.response.path;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class RoutePathResBody<T> {

    @JsonProperty("itemList")
    private List<RoutePathResBodyList> itemList;

    private RoutePathResBody() {}
}
