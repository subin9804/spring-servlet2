package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    // MultiValueMap : 한 개의 키에 여러개의 값을 받을 수 있다.
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request, HttpServletResponse response,
                          HttpMethod httpMethod, Locale locle,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value="myCookie", required = false) String cookie) {
        log.info("request={}",request);
        log.info("response={}",response);
        log.info("httpMethod={}",httpMethod);
        log.info("locle={}",locle); // localeResolver 확인
        log.info("headerMap={}",headerMap);
        log.info("host={}",host);
        log.info("cookie={}",cookie);

        return "ok";
    }
}
