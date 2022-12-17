package kyu.pj.transportinformation.topis.transfer.data.response.busnsub;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class TransferBusNSubResBody<T> {

    @JsonProperty("itemList")
    private List<TransferBusNSubResBodyList> itemList;

    private TransferBusNSubResBody() {}
}
