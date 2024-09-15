package com.arun.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
public class JobParamRequest {
    
    private String key;
    
    private String value;
}
