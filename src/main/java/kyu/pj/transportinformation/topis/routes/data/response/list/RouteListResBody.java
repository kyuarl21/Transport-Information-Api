package kyu.pj.transportinformation.topis.routes.data.response.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class RouteListResBody<T> {

    @JsonProperty("itemList")
    private List<RouteListResBodyList> itemList;

    private RouteListResBody() {}
}
