package kyu.pj.transportinformation.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "topis")
public class TopisProperties {

    private String scheme;
    private String host;
    private String encodingKey;
    private String decodingKey;
}
