package com.store.videogames.modules.platform.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.store.videogames.modules.platform.entity.Platform;
import com.store.videogames.modules.platform.services.Implement.PlatformImplement;

@RestController
@RequestMapping("/api/v1/platform")
public class PlatformController {

    @Autowired
    PlatformImplement service;

    @PostMapping("/create")
    public ResponseEntity<Object> Create(@RequestBody Platform platform) {
        String retorno = service.Create(platform);
        return new ResponseEntity<Object>(retorno, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Platform>> GetAll() {
        var retorno = service.GetAll();
        return new ResponseEntity<List<Platform>>(retorno, HttpStatus.OK);
    }
}