package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;

import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@Controller()
public class PlayerController {

    private static final Logger log = getLogger(PlayerController.class);

    ObjectMapper mapper = new ObjectMapper();

    @Get(produces = MediaType.TEXT_PLAIN)
    public String doGet() {
        return "Java player is running";
    }

    @Post(produces = MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String doPost(@Body Map<String, String> body) throws JsonProcessingException {
        String action = body.get("action");
        String gameState = body.get("game_state");
        if ("bet_request".equals(action)) {
            String response = String.valueOf(PlayerLogic.betRequest(mapper.readTree(gameState)));
            log.info("bet_request response: " + response);
            return response;
        }
        if ("showdown".equals(action)) {
            log.info("showdown: " + gameState);
            PlayerLogic.showdown(mapper.readTree(gameState));
        }
        if ("version".equals(action)) {
            return PlayerLogic.VERSION;
        }
        return "";
    }

}
