package kyu.pj.transportinformation.topis.service;

import kyu.pj.transportinformation.client.topis.TopisClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class TopisService {

    private final TopisClient topisClient;

    public String getRouteList(String search) {
        String result = topisClient.getRouteList(search);
        return result;
    }

    public String getRouteInfo(String routeId) {
        String result = topisClient.getRouteInfo(routeId);
        return result;
    }

    public String getRoutePath(String routeId) {
        String result = topisClient.getRoutePath(routeId);
        return result;
    }

    public String getStationByRoute(String routeId) {
        String result = topisClient.getStationByRoute(routeId);
        return result;
    }

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

    public String getPositionByRouteId(String routeId) {
        String result = topisClient.getPositionByRouteId(routeId);
        return result;
    }

    public String getPositionByStation(String routeId, String startStation, String endStation) {
        String result = topisClient.getPositionByStation(routeId, startStation, endStation);
        return result;
    }

    public String getPositionByBusId(String busId) {
        String result = topisClient.getPositionByBusId(busId);
        return result;
    }

    public String busArrive(String routeId) {
        String result = topisClient.getBusArrive(routeId);
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
