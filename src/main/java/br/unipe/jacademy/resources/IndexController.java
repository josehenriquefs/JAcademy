package br.unipe.jacademy.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/")
    private String index() {
    	return "index";
	}
}
