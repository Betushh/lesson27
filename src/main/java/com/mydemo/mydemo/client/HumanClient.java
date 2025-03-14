package com.mydemo.mydemo.client;

import com.mydemo.mydemo.Models.Human;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "human-service", url = "http://localhost:8081")
public interface HumanClient {

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    List<Human> getList();

    @GetMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    Human getById(@PathVariable Integer id);

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    Human add(@RequestBody Human human);

    @PutMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    Human update(Human human);

    @DeleteMapping("/clients")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(Integer id);
}
