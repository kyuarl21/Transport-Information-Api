package kyu.pj.transportinformation.inquiry.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kyu.pj.transportinformation.common.Status;
import kyu.pj.transportinformation.handler.exception.BadRequestException;
import kyu.pj.transportinformation.inquiry.data.response.StationArriveResDto;
import kyu.pj.transportinformation.topis.stations.data.response.byid.StationByIdResponse;
import kyu.pj.transportinformation.topis.stations.data.response.byname.StationByNameResponse;
import kyu.pj.transportinformation.topis.stations.service.StationsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class InquiryService {

    private final StationsService stationsService;

    public Object getStationArrive(String stationName) {

        List<StationByNameResponse> stationByNameResponseList = stationsService.getStationByName(stationName).getServiceResult().getMsgBody().getItemList();
        StationArriveResDto stationArriveResDto = new StationArriveResDto();

        JSONObject jsonObject = new JSONObject(stationByNameResponseList.get(0));
        String stationId = jsonObject.get("arsId").toString();
        List<StationByIdResponse> stationByIdResponseList = stationsService.getStationById(stationId).getServiceResult().getMsgBody().getItemList();
        System.out.println(stationByIdResponseList);

        /*for (int i = 0; i < stationResponseByNameList.size(); i++) {
            JSONObject jsonObject = new JSONObject(stationResponseByNameList.get(i));
            String stationId = jsonObject.get("arsId").toString();
            List<StationResponseById> stationResponseByIdList = stationsService.getStationById(stationId).getServiceResult().getMsgBody().getItemList();

            for (int j = 0; j < stationResponseByIdList.size(); j++) {
                System.out.println(stationResponseByIdList);

            }
        }*/

        return stationByIdResponseList;
    }

    public StationArriveResDto resVoToDto(String jsonString) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .build();

        try {
            return objectMapper.readValue(jsonString, StationArriveResDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new BadRequestException(Status.FAIL_CODE, Status.FAIL_MSG);
        }
    }
}
