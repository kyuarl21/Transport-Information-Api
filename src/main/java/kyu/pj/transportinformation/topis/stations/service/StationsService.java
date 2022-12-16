package kyu.pj.transportinformation.topis.stations.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kyu.pj.transportinformation.common.Status;
import kyu.pj.transportinformation.handler.exception.BadRequestException;
import kyu.pj.transportinformation.topis.client.TopisClient;;
import kyu.pj.transportinformation.topis.stations.data.response.byid.StationResponseById;
import kyu.pj.transportinformation.topis.stations.data.response.byname.StationResponseByName;
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

    public StationResponseByName getStationByName(String stationName) {

        String stationRes = topisClient.getStationByName(stationName);

        JSONObject jsonObject = XML.toJSONObject(stationRes);

        return jsonToStationVoByName(jsonObject.toString());
    }

    public StationResponseById getStationById(String stationId) {

        String stationRes = topisClient.getStationById(stationId);

        JSONObject jsonObject = XML.toJSONObject(stationRes);

        return jsonToStationVoById(jsonObject.toString());
    }

    public String getRouteByStation(String stationId) {
        String result = topisClient.getRouteByStation(stationId);
        return result;
    }

    public boolean isNumeric(String station) {
        boolean isNumber = true;
        for (int i = 0; i < station.length(); i++) {
            if (!Character.isDigit(station.charAt(i))) {
                isNumber = false;
            }
        }
        return isNumber;
    }

    public StationResponseByName jsonToStationVoByName(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, StationResponseByName.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public StationResponseById jsonToStationVoById(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, StationResponseById.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }
}
