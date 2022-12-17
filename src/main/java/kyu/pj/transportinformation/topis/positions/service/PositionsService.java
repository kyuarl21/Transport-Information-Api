package kyu.pj.transportinformation.topis.positions.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kyu.pj.transportinformation.common.Status;
import kyu.pj.transportinformation.handler.exception.BadRequestException;
import kyu.pj.transportinformation.topis.client.TopisClient;
import kyu.pj.transportinformation.topis.positions.data.response.bybus.BusPositionByBusResponse;
import kyu.pj.transportinformation.topis.positions.data.response.byroute.BusPositionByRouteResponse;
import kyu.pj.transportinformation.topis.positions.data.response.bystation.BusPositionByStationResponse;
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
public class PositionsService {

    private final TopisClient topisClient;

    public BusPositionByRouteResponse getPositionByRouteId(String routeId) {
        String positionResByRoute = topisClient.getPositionByRouteId(routeId);

        JSONObject jsonObject = XML.toJSONObject(positionResByRoute);

        return jsonToPositionVoByRoute(jsonObject.toString());
    }

    public BusPositionByStationResponse getPositionByStation(String routeId, String startStation, String endStation) {
        String positionResByStation = topisClient.getPositionByStation(routeId, startStation, endStation);

        JSONObject jsonObject = XML.toJSONObject(positionResByStation);

        return jsonToPositionVoByStation(jsonObject.toString());
    }

    public BusPositionByBusResponse getPositionByBusId(String busId) {
        String positionResByStation = topisClient.getPositionByBusId(busId);

        JSONObject jsonObject = XML.toJSONObject(positionResByStation);

        return jsonToPositionVoByBus(jsonObject.toString());
    }

    public BusPositionByRouteResponse jsonToPositionVoByRoute(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, BusPositionByRouteResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public BusPositionByStationResponse jsonToPositionVoByStation(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, BusPositionByStationResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public BusPositionByBusResponse jsonToPositionVoByBus(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, BusPositionByBusResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }
}
