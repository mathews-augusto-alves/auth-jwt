package br.com.project.interfaces.controller.authenticated.test;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/")
    @Secured("ROLE_USER")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(null);
    }
}
