package vs.servererrors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("errors")
public class ErrorController {

    final ObjectMapper mapper;

    ErrorController(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("none")
    public ResponseEntity<String> none() {
        return ResponseEntity.ok("no errors");
    }

    @GetMapping("client")
    public ResponseEntity<ObjectNode> client() {
        ObjectNode error = mapper.createObjectNode()
                .put("error", "client")
                .put("status", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @GetMapping("server")
    public ResponseEntity<ObjectNode> server() {
        ObjectNode error = mapper.createObjectNode()
                .put("error", "server")
                .put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @GetMapping("random")
    public ResponseEntity random() {
        int percentage = ThreadLocalRandom.current().nextInt(1, 11);

        if (percentage < 5) {
            return none();
        } else if (percentage < 8) {
            return client();
        } else {
            return server();
        }
    }

}
