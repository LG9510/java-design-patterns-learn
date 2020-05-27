package life.majiang.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 10122
 * @CreateTime: 2020-05-26 15:38
 * @Description: 控制器
 */
@Controller
public class IndexController {
    @GetMapping("/hello")
    public String hello (@RequestParam(name = "name")String name, Model model){
        //key-value
        model.addAttribute("name",name);
        //自动寻找templates文件夹中的文件
        return "index";
    }
}
