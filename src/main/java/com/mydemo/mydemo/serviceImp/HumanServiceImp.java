package com.mydemo.mydemo.serviceImp;

import com.mydemo.mydemo.Models.Human;
import com.mydemo.mydemo.Services.HumanService;
import com.mydemo.mydemo.client.HumanClient;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Service("human")
@Slf4j
@RequiredArgsConstructor
public class HumanServiceImp implements HumanService {

    //    private final WebClient webClient;
    private final HumanClient humanClient;

    @Override
    public List<Human> getList() {
        return humanClient.getList();
//        ResponseEntity<List<Human>> human = webClient
//                .get().uri("/clients")
//                .retrieve()
//                .toEntityList(Human.class).block();
//        return human.getBody();
    }


    public Human getHumanbyID(Integer id) {
        return humanClient.getById(id);
//        ResponseEntity<Human> human = webClient
//                .get().uri("/clients/"+id)
//                .retrieve()
//                .toEntity(Human.class).block();
//        return human.getBody();
    }

    @Override
    public Human add(Human human) {
        return humanClient.add(human);
//        return webClient.post()
//                .uri("/clients")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(human)
//                .retrieve()
//                .bodyToMono(Human.class).block();
    }

    @Override
    public Human update(Human human) {
        return humanClient.update(human);
    }

    @Override
    public void delete(Integer id) {
        humanClient.delete(id);
    }
}
