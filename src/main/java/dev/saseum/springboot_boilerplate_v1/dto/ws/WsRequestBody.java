package dev.saseum.springboot_boilerplate_v1.dto.ws;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WsRequestBody {
    String from;

    String to;

    String content;

    String type;

    long date;
}