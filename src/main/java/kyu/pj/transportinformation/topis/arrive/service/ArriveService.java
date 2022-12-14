package kyu.pj.transportinformation.topis.arrive.service;

import kyu.pj.transportinformation.topis.client.TopisClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArriveService {

    private final TopisClient topisClient;

    public String busArrive(String routeId) {
        String result = topisClient.getBusArrive(routeId);
        return result;
    }
}
