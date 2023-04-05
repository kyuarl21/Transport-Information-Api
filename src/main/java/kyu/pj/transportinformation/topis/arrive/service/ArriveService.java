package kyu.pj.transportinformation.topis.arrive.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kyu.pj.transportinformation.common.Status;
import kyu.pj.transportinformation.exception.BadRequestException;
import kyu.pj.transportinformation.topis.arrive.data.response.bystation.BusArriveByStationResponse;
import kyu.pj.transportinformation.topis.arrive.data.response.info.BusArriveResponse;
import kyu.pj.transportinformation.topis.client.TopisClient;
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
public class ArriveService {

    private final TopisClient topisClient;

    public BusArriveResponse getBusArrive(String routeId) {
        String arriveRes = topisClient.getBusArrive(routeId);

        JSONObject jsonObject = XML.toJSONObject(arriveRes);

        return jsonToArriveResVo(jsonObject.toString());
    }

    public BusArriveByStationResponse getBusArriveByStation(String stationId, String routeId, String order) {
        String arriveResByStation = topisClient.getBusArriveByStation(stationId, routeId, order);

        JSONObject jsonObject = XML.toJSONObject(arriveResByStation);

        return jsonToArriveResByStationVo(jsonObject.toString());
    }

    public BusArriveResponse jsonToArriveResVo(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, BusArriveResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public BusArriveByStationResponse jsonToArriveResByStationVo(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, BusArriveByStationResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }
}
