package za.co.sasams.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: magwa
 * Date: 2012/08/22
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class TestController {

    @RequestMapping("/hello")
    public ModelAndView helloWorld() {

        String message = "Hello World, Spring 3.0!";
        return new ModelAndView("hello", "message", message);
    }


}
