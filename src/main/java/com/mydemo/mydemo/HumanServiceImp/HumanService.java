package com.mydemo.mydemo.HumanServiceImp;

import com.mydemo.mydemo.Models.Human;

import java.util.List;

public interface HumanService {

    List<Human> getList();

    Human getStudentbyID(Integer id, String name);

    Human getHumanByName(Integer id, String name);

    Human add(Human human);

    Human update(Human human);

    void delete(Integer id);
}


