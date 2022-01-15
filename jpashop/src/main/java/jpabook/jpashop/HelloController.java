package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello";
        // 리턴하는 값이 템플릿 이름이 됨 hello.html로 자동 변환
        // resources , template에 있는 html 파일로 이동 됨
    }

}
