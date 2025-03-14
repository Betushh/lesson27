package com.mydemo.mydemo.Services;

import com.mydemo.mydemo.Models.Human;

import java.util.List;

public interface HumanService {

    List<Human> getList();

     Human getHumanbyID(Integer id);

    Human add(Human human);

    Human update(Human human);

    void delete(Integer id);
}


