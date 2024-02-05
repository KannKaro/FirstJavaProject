package pl.kantos.First;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AddNumber {
    @GetMapping("/test")
    public int AddNum(@RequestParam("n1") int n1, @RequestParam("n2") int n2) {
        return n1 + n2;
    }
}
