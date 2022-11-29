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

    public String busArrive() {
        String result = topisClient.getBusArrive();

        return result;
    }

    public String getStationByName(String stationName) {
        String result = topisClient.getStationByName(stationName);
        return result;
    }
}
