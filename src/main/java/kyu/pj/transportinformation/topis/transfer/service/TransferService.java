package kyu.pj.transportinformation.topis.transfer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kyu.pj.transportinformation.common.Status;
import kyu.pj.transportinformation.exception.BadRequestException;
import kyu.pj.transportinformation.topis.client.TopisClient;
import kyu.pj.transportinformation.topis.transfer.data.response.busnsub.TransferBusNSubResponse;
import kyu.pj.transportinformation.topis.transfer.data.response.bybus.TransferByBusResponse;
import kyu.pj.transportinformation.topis.transfer.data.response.bysubway.TransferBySubResponse;
import kyu.pj.transportinformation.topis.transfer.data.response.info.TransferPathResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class TransferService {

    private final TopisClient topisClient;

    public TransferPathResponse getTransferPath(String search) {

        String transferPathRes = topisClient.getTransferPath(search);

        JSONObject jsonObject = XML.toJSONObject(transferPathRes);

        return jsonToTransferPathResponse(jsonObject.toString());
    }

    public TransferByBusResponse getTransferByBus(String startX, String startY, String endX, String endY) {

        String transferByBusRes = topisClient.getTransferByBus(startX, startY, endX, endY);

        JSONObject jsonObject = XML.toJSONObject(transferByBusRes);
        System.out.println(jsonObject);

        return jsonToTransferByBusResponse(jsonObject.toString());
    }

    public TransferBySubResponse getTransferBySubway(String startX, String startY, String endX, String endY) {

        String transferBySubRes = topisClient.getTransferBySubway(startX, startY, endX, endY);

        JSONObject jsonObject = XML.toJSONObject(transferBySubRes);

        return jsonToTransferBySubResponse(jsonObject.toString());
    }

    public TransferBusNSubResponse getTransferByBusNSub(String startX, String startY, String endX, String endY) {

        String transferBusNSubRes = topisClient.getTransferByBusNSub(startX, startY, endX, endY);

        JSONObject jsonObject = XML.toJSONObject(transferBusNSubRes);

        return jsonToTransferBusNSubResponse(jsonObject.toString());
    }

    public TransferPathResponse jsonToTransferPathResponse(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, TransferPathResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public TransferByBusResponse jsonToTransferByBusResponse(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, TransferByBusResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public TransferBySubResponse jsonToTransferBySubResponse(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, TransferBySubResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public TransferBusNSubResponse jsonToTransferBusNSubResponse(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, TransferBusNSubResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }
}
