package kyu.pj.transportinformation.topis.stations.data.response.byid;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class StationByIdResBody<T> {

    @JsonProperty("itemList")
    private List<StationByIdResBodyList> itemList;

    private StationByIdResBody() {}
}
