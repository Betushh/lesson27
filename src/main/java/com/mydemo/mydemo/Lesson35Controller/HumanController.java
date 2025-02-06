package com.mydemo.mydemo.Lesson35Controller;

import com.mydemo.mydemo.HumanServiceImp.HumanService;
import com.mydemo.mydemo.Models.Human;
import com.mydemo.mydemo.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Humans")

public class HumanController {

//    @Autowired
    private final HumanService humanService;


    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

//    public void setHumanController(HumanService humanService) {
//        this.humanService = humanService;
//    }


    @GetMapping
    public List<Human> getList() {
        return humanService.getList();
    }

    @GetMapping("/id")
    public Human getStudentByID(@RequestParam(required = false) Integer id, @RequestParam String name) {
        return humanService.getStudentbyID(id, name);
    }

    @GetMapping("/{id}/{name}")
    public Human getHumanByName(@PathVariable(name = "id") Integer id, @PathVariable String name) {
        return humanService.getHumanByName(id, name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Human add(@RequestBody Human human) {
        return humanService.add(human);
    }

    @PutMapping
    public Human update(@RequestBody Human human) {
        return humanService.update(human);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        humanService.delete(id);
    }
}
