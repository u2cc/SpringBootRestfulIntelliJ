package org.u2cc.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.u2cc.rest.model.Greeting;
import org.u2cc.rest.model.User;

import java.util.concurrent.atomic.AtomicLong;


/**
 * Controller class for all the endpoints configuration
 * @author James Chen
 */
@Api(value="RESTful Endpoints")
@RestController
public class SpringBootRestfulController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootRestfulController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * The example can choose not to specify GET vs. PUT, POST and so forth because @Requestmaping maps all HTTP operations by default
     * Use @RequestMapping(method=GET) to narrow this mapping.
     * This endpoint handles in-path request parameters instead of JSON therefore the use of @RequestParam
     * @param name
     * @return
     */
    @ApiOperation(value = "Greet everyone", notes="10ms processing time")
    @RequestMapping(path="/greeting", method = RequestMethod.GET)
    public Greeting greeting(@ApiParam(value = "Name to be used in the response")@RequestParam(value="name",defaultValue="World") String name) {
        StopWatch timer = new StopWatch();
        timer.start();

        try{
            LOGGER.info("[ Processing Request: NAME|"+name+"]");
            Thread.sleep(10);

        }catch (InterruptedException e){
            LOGGER.info("[ Thread sleep for 10ms interrupted ]", e);
        }
        timer.stop();
        LOGGER.info(" [Process Time for" + "NAME|" + name + ": " + timer.getTotalTimeMillis() + "ms ]");

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    public User getUserDetails(@ApiParam(value = "User Criteria", required = true)@RequestBody User user) {
        LOGGER.info("Receiving payload: " + user.toString());
        return user;
    }
}
