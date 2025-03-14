package com.mydemo.mydemo.controller;

import com.mydemo.mydemo.Services.HumanService;
import com.mydemo.mydemo.Models.Human;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/humans")
public class HumanController {

    private final HumanService humanService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Human> getList() {
        return humanService.getList();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public Human getHumanbyID(Integer id) {
        return humanService.getHumanbyID(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Human add(@RequestBody Human human) {
        return humanService.add(human);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Human update(@RequestBody Human human) {
        return humanService.update(human);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        humanService.delete(id);
    }
}
