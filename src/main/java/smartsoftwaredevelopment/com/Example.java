package smartsoftwaredevelopment.com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {

  @RequestMapping("/hello")
  String home() {
    return "Hello World!";
  }
}
