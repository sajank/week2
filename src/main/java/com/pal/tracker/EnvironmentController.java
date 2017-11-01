package com.pal.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvironmentController {

    static Logger log = LoggerFactory.getLogger(EnvironmentController.class.getName());

    private String cfIndex;

    public EnvironmentController(@Value("${CF_INSTANCE_INDEX:NOT SET}") String cfIndex) {
        log.info("Constructor: CF_INSTANCE_INDEX value set to default \"NOT SET\"");
        this.cfIndex = cfIndex;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> map = new HashMap<>();
        log.info("getEnv: CF_INSTANCE_INDEX added to Map to reflect the instance.");
        map.put("CF_INSTANCE_INDEX", cfIndex);
        return map;
    }
}