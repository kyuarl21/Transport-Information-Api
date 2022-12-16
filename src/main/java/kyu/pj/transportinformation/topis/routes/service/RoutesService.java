package kyu.pj.transportinformation.topis.routes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kyu.pj.transportinformation.common.Status;
import kyu.pj.transportinformation.handler.exception.BadRequestException;
import kyu.pj.transportinformation.topis.client.TopisClient;
import kyu.pj.transportinformation.topis.routes.data.response.info.RouteInfoResponse;
import kyu.pj.transportinformation.topis.routes.data.response.list.RouteListResponse;
import kyu.pj.transportinformation.topis.routes.data.response.path.RoutePathResponse;
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
public class RoutesService {

    private final TopisClient topisClient;

    public RouteListResponse getRouteList(String search) {
        String routeListRes = topisClient.getRouteList(search);

        JSONObject jsonObject = XML.toJSONObject(routeListRes);

        return jsonToRouteListVo(jsonObject.toString());
    }

    public RouteInfoResponse getRouteInfo(String routeId) {
        String routeInfoRes = topisClient.getRouteInfo(routeId);

        JSONObject jsonObject = XML.toJSONObject(routeInfoRes);

        return jsonToRouteInfoVo(jsonObject.toString());
    }

    public RoutePathResponse getRoutePath(String routeId) {
        String routePathRes = topisClient.getRoutePath(routeId);

        JSONObject jsonObject = XML.toJSONObject(routePathRes);

        return jsonToRoutePathVo(jsonObject.toString());
    }

    public String getStationByRoute(String routeId) {
        String result = topisClient.getStationByRoute(routeId);
        return result;
    }

    public RouteListResponse jsonToRouteListVo(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, RouteListResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public RouteInfoResponse jsonToRouteInfoVo(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, RouteInfoResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }

    public RoutePathResponse jsonToRoutePathVo(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, RoutePathResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }
}
