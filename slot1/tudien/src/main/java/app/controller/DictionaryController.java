package app.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
  public static Map<String,String> list = new HashMap<>();
  static {
    list.put("hello","Xin Chào");
    list.put("bye","Tạm Biệt");
    list.put("name","Tên");
    list.put("game","Trò chơi");
  }
  @GetMapping("/translate")
  public String getWord(Model model,@RequestParam("word") String word) {
      String result = list.get(word);
      if(result == null){
        model.addAttribute("word",word);
        model.addAttribute("result","Không tìm thấy");
      }else{
        model.addAttribute("word",word);
        model.addAttribute("result",result);
      }
      return "index";
  }
}
