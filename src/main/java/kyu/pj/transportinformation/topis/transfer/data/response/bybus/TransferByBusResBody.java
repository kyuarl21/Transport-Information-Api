package kyu.pj.transportinformation.topis.transfer.data.response.bybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class TransferByBusResBody {

    @JsonProperty("itemList")
    private List<TransferByBusResBodyList> itemList;

    private TransferByBusResBody() {}
}
