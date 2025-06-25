package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }


    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String mappigGetv1() {
        log.info("mapping-get-v1");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션
     * @return
     */
    @GetMapping(value = "/hello-basic")
    public String mappigGetv2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userID -> @PathVarible userId
     * /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    }
}
