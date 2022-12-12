package kyu.pj.transportinformation.topis.stations.service;

import kyu.pj.transportinformation.client.topis.TopisClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class StationsService {

    private final TopisClient topisClient;

    public String getStation(String station) {
        boolean isNumber = isNumeric(station);
        String result = null;

        if (!isNumber) {
            result = topisClient.getStationByName(station);
        } else {
            result = topisClient.getStationById(station);
        }
        return result;
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
}
