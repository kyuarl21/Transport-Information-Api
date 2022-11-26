package kyu.pj.transportinformation.client.topis;

import kyu.pj.transportinformation.common.properties.TopisProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class TopisClient {

    private final WebClient webClient;
    private final TopisProperty topisProperty;

    @Autowired
    public TopisClient(TopisProperty topisProperty) {
        this.topisProperty = topisProperty;
        this.webClient = WebClient.builder()
                .baseUrl(UriComponentsBuilder.newInstance()
                        .scheme(topisProperty.getScheme())
                        .host(topisProperty.getHost())
                        .build().toUriString()
                ).defaultHeaders(this::defaultHeaders)
                .build();
    }

    private void defaultHeaders(HttpHeaders headers) {
        headers.add("content-type", "application/json; charset=utf-8");
    }
}
