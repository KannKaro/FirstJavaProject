package pl.kantos.First;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddNumber {
    @GetMapping("/test")
    public int AddNum() {
        return 1;
    }
}
