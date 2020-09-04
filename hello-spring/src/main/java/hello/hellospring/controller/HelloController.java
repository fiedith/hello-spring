package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // controller annotation
public class HelloController {

    @GetMapping("greetings")    // localhost:8080/greetings에 해당함
    public String hello(Model model){
        model.addAttribute("data", "this data goes into the $data thingy in hello.html bruh");
        return "hello"; // src.main.resources.static 내에 있는 "hello.html"의 이름의 파일을 return해줌
    }

    @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam("name") String name, Model model){
            model.addAttribute("name", name);
            return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // API
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
