package com.helloworld.rest_api.service;

import com.helloworld.rest_api.dto.ItemDto;
import com.helloworld.rest_api.mapper.RestApiMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
@Slf4j
public class RestApiService {
    @Autowired
    private RestApiMapper restApiMapper;

    public boolean registerItem(ItemDto itemDto) {
        // TODO: DB Insert
        log.info("DB Insert ...");

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", itemDto.getId());
        paramMap.put("name", itemDto.getName());


        restApiMapper.registerItem(paramMap);

        return true;
    }

    public ItemDto getItemById(String id) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        HashMap<String, Object> response = restApiMapper.findById(paramMap);

        ItemDto itemDto = new ItemDto();
        itemDto.setId((String) response.get("ID"));
        itemDto.setName((String) response.get("NAME"));

        return itemDto;

    }
}
