package kyu.pj.transportinformation.client.topis;

import com.fasterxml.jackson.databind.JsonNode;
import kyu.pj.transportinformation.common.properties.TopisProperty;
import kyu.pj.transportinformation.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

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

    public String getBusArrive() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/getArrInfoByRouteAll")
                        .queryParam("ServiceKey", topisProperty.getDecodingKey())
                        .queryParam("busRouteId", "100100118")
                        .build()
                ).exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(String.class);
                    }
                    return response.createException().flatMap(it -> {
                        String bodyAsString = it.getResponseBodyAsString(StandardCharsets.UTF_8);
                        return Mono.error(new BadRequestException(111, bodyAsString)); // TODO
                    });
                }).onErrorResume(error -> {
                    log.debug("error : {}", error.getMessage());
                    return Mono.error(new BadRequestException(111, error.getMessage())); // TODO
                }).block();
    }

    private void defaultHeaders(HttpHeaders headers) {
        headers.add("content-type", "application/json; charset=utf-8");
    }
}
