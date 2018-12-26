package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExchangingCurrency {
  @GetMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping(value = "/convert", method = RequestMethod.POST)
  public ModelAndView convert(@RequestParam Float rate, Float usd) {
    ModelAndView modelAndView = new ModelAndView("convert");
    modelAndView.addObject("rate", rate);
    modelAndView.addObject("usd", usd);
    float vnd = rate*usd;
    modelAndView.addObject("vnd", vnd);
    return modelAndView;
  }
}
