package kyu.pj.transportinformation.topis.arrive.data.response.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class BusArriveResBody<T> {

    @JsonProperty("itemList")
    private List<BusArriveResBodyList> itemList;

    private BusArriveResBody() {}
}
