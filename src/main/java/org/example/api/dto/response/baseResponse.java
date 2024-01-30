package org.example.api.dto.response;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@SuperBuilder
@Getter
public class baseResponse {
    private Long productId;
}
