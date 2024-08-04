package com.helloworld.rest_api.controller;

import com.helloworld.rest_api.dto.ItemDto;
import com.helloworld.rest_api.dto.ItemResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RestApiController {

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

    @PatchMapping("/item")
    public ItemResponseDto registerItem(@RequestBody ItemDto item) {
        log.info("item: {}", item);
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setMessage("OK");
        return itemResponseDto;
    }
}
