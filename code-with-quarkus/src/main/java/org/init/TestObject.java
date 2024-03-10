package org.init;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TestObject {

    private String name;
    private String surname;
    private LocalDateTime dateTime;
    private String appName;

}
