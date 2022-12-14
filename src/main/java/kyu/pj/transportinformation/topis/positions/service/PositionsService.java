package kyu.pj.transportinformation.topis.positions.service;

import kyu.pj.transportinformation.topis.client.TopisClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PositionsService {

    private final TopisClient topisClient;

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
}
