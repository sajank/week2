package com.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvironmentController {

    private String cfIndex;

    public EnvironmentController(@Value("${CF_INSTANCE_INDEX:NOT SET}") String cfIndex) {
        this.cfIndex = cfIndex;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> map = new HashMap<>();
        map.put("CF_INSTANCE_INDEX", cfIndex);
        return map;
    }
}
