package kyu.pj.transportinformation.topis.transfer.data.response.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class TransferPathResBody<T> {

    @JsonProperty("itemList")
    private List<TransferPathResBodyList> itemList;

    private TransferPathResBody() {}
}
