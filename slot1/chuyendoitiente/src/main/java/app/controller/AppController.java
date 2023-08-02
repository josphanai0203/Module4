package app.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
@GetMapping("/convert")
  public String convertMoney(@RequestParam("money") String money,Model model){
  double moneyConvert = Double.parseDouble(money);
  moneyConvert = moneyConvert * 23740.50;
  DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

  String formattedAmount = formatter.format(moneyConvert);
  model.addAttribute("money",money);
  model.addAttribute("result",formattedAmount);
  return "index";

}
}