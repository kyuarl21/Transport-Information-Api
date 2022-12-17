package kyu.pj.transportinformation.topis.transfer.data.response.bysubway;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class TransferBySubResBody<T> {

    @JsonProperty("itemList")
    private List<TransferBySubResBodyList> itemList;

    private TransferBySubResBody() {}
}
