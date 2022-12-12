package kyu.pj.transportinformation.topis.routes.service;

import kyu.pj.transportinformation.client.topis.TopisClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class RoutesService {

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
}
