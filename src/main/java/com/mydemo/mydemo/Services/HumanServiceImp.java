package com.mydemo.mydemo.Services;

import com.mydemo.mydemo.HumanServiceImp.HumanService;
import com.mydemo.mydemo.Models.Human;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HumanServiceImp implements HumanService {


    @Override
    public List<Human> getList() {
        return List.of(
                new Human(1, "human1", "Homo sapiens"),
                new Human(2, "human2", "Primate"),
                new Human(3, "human3", "Bipedal Mammal")
        );
    }

    @Override
    public Human getStudentbyID(Integer id, String name) {
        return new Human(id, name, "Homo sapiens");
    }

    @Override
    public Human getHumanByName(Integer id, String name) {
        return new Human(id, name, "Homo sapiens");
    }

    @Override
    public Human add(Human human) {
        return human;
    }

    @Override
    public Human update(Human human) {
        return human;
    }

    @Override
    public void delete(Integer id) {
        log.trace("This is deleted succesfully "+ id);
    }
}
