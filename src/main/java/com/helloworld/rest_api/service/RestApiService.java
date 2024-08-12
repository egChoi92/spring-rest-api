package com.helloworld.rest_api.service;

import com.helloworld.rest_api.dto.ItemDto;
import com.helloworld.rest_api.entity.ItemEntity;
import com.helloworld.rest_api.mapper.RestApiMapper;
import com.helloworld.rest_api.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
@Slf4j
public class RestApiService {
//    @Autowired
//    private RestApiMapper restApiMapper;

    @Autowired
    private ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto) {
        /*  // Mybatis - Insert Code
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", itemDto.getId());
        paramMap.put("name", itemDto.getName());

        restApiMapper.registerItem(paramMap);

        return true;
        */

        // JPA - Insert Code
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        // .save() : Insert, Update
        itemRepository.save(itemEntity);

        return true;

    }

    public ItemDto getItemById(String id) {
        /*  // Mybatis - Select Code
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        HashMap<String, Object> response = restApiMapper.findById(paramMap);

        ItemDto itemDto = new ItemDto();
        itemDto.setId((String) response.get("ID"));
        itemDto.setName((String) response.get("NAME"));

        return itemDto;
        */

        // JPA - Select Code
        // .findById() : Select
        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;


    }
}
