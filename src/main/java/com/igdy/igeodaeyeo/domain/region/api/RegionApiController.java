package com.igdy.igeodaeyeo.domain.region.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/region")
public class RegionApiController {

//    @RequestMapping(value = "/regions", method = RequestMethod.GET)
    @GetMapping("/regions")
    public ResponseEntity<List<String>> getRegionList() {
        List<String> list = new ArrayList<String>();
        list.add("서울");
        list.add("광주");
        list.add("대구");
        list.add("부산");

        return ResponseEntity.ok().body(list);
    }

}