package kyu.pj.transportinformation.topis.stations.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kyu.pj.transportinformation.common.Status;
import kyu.pj.transportinformation.exception.BadRequestException;
import kyu.pj.transportinformation.topis.client.TopisClient;;
import kyu.pj.transportinformation.topis.stations.data.response.byid.StationByIdResponse;
import kyu.pj.transportinformation.topis.stations.data.response.byname.StationByNameResponse;
import kyu.pj.transportinformation.topis.stations.data.response.byroute.StationByRouteResponse;
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
public class StationsService {

    private final TopisClient topisClient;

    public StationByNameResponse getStationByName(String stationName) {

        String stationRes = topisClient.getStationByName(stationName);

        JSONObject jsonObject = XML.toJSONObject(stationRes);

        return jsonToStationVoByName(jsonObject.toString());
    }

    public StationByIdResponse getStationById(String stationId) {

        String stationRes = topisClient.getStationById(stationId);

        JSONObject jsonObject = XML.toJSONObject(stationRes);

        return jsonToStationVoById(jsonObject.toString());
    }

    public StationByRouteResponse getStationByRoute(String routeId) {
        String stationRes = topisClient.getStationByRoute(routeId);

        JSONObject jsonObject = XML.toJSONObject(stationRes);

        return jsonToStationVoByRoute(jsonObject.toString());
    }

    public StationByNameResponse jsonToStationVoByName(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, StationByNameResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public StationByIdResponse jsonToStationVoById(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, StationByIdResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public StationByRouteResponse jsonToStationVoByRoute(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, StationByRouteResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public boolean isNumer(String station) {
        boolean isNumber = true;
        for (int i = 0; i < station.length(); i++) {
            if (!Character.isDigit(station.charAt(i))) {
                isNumber = false;
            }
        }
        return isNumber;
    }
}
