package karma.practice02.swaggercodegen.web;

import karma.practice02.swaggercodegen.AppApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController implements AppApi {

    @Override
    public ResponseEntity<String> checkApplication() {
        return new ResponseEntity<>("It's working!", HttpStatus.OK);
    }
}
