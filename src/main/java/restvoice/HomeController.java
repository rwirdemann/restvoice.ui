package restvoice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Invoice[] response = restTemplate.getForObject("http://localhost:8190/invoice", Invoice[].class);
        model.addAttribute("invoices", response);

        return "index";
    }

    @GetMapping("/new_invoice")
    public String newInvoice() {
        return "invoice";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "index";
    }
}