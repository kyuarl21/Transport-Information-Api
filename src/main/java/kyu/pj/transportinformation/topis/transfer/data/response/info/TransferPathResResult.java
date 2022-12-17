package kyu.pj.transportinformation.topis.transfer.data.response.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import kyu.pj.transportinformation.topis.common.TopisResHeader;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TransferPathResResult<T> {

    @JsonProperty("msgHeader")
    private TopisResHeader<T> msgHeader;

    @JsonProperty("msgBody")
    private TransferPathResBody<T> msgBody;

    private TransferPathResResult() {}
}
