package tqs.homework_assignment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TravelController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
