package com.helloworld.rest_api.controller;

import com.helloworld.rest_api.dto.ItemDto;
import com.helloworld.rest_api.dto.ItemResponseDto;
import com.helloworld.rest_api.service.RestApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RestApiController {

    @Autowired
    private RestApiService restApiService;

    @GetMapping("/dummy")
    public String dummy(){
        log.info("dummy");
        return "{}";
    }


    @GetMapping("/dummy2")
    public String dummy2(){
        log.info("dummy2");
        return "{name: '최은광'}";
    }


    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo, @RequestParam("year") int year){
        log.info("empNo: {}", empNo);
        log.info("year: {}", year);
        return "OK";
    }

    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id) {
        log.info("id: {}", id);
        return "OK";
    }

    @PostMapping ("/item")
    public ItemResponseDto registerItem(@RequestBody ItemDto item) {
        log.info("item: {}", item);

        boolean isRegister = restApiService.registerItem(item);
        if (isRegister) {

            ItemResponseDto itemResponseDto = new ItemResponseDto();
            itemResponseDto.setMessage("OK");
            return itemResponseDto;
        }
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setMessage("Fail");
        return itemResponseDto;
    }

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {

        return restApiService.getItemById(id);
    }
}
