package com.example.ApiRestFulSpringBoot.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    public String get()
    {
        return "Get Spring Boot";
    }

    @PostMapping("/login")
    public String login (@RequestParam("usuario") String usuario, @RequestParam("senha") String senha)
    {
        return "Usuario " + usuario + ", senha " + senha;
    }
}
