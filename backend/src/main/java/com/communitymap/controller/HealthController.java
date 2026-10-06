package com.communitymap.controller;
import io.micronaut.http.annotation.*;
import java.util.Map;
@Controller("/api/health")
public class HealthController {
 @Get public Map<String,String> health(){return Map.of("status","UP","application","community-map-api");}
}
