package kyu.pj.transportinformation.topis.stations.data.response.byname;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class StationByNameResBody<T> {

    @JsonProperty("itemList")
    private List<StationByNameResBodyList> itemList;

    private StationByNameResBody() {}
}
