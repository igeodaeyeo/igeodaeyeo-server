package com.igdy.igeodaeyeo.domain.example.controller;

import com.igdy.igeodaeyeo.domain.example.dto.ExampleRequest;
import com.igdy.igeodaeyeo.domain.example.dto.ExampleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping("")
    public ResponseEntity<String> getExample() {
        // 여기에 비즈니스 로직을 추가하여 실제 응답을 생성합니다.
        return ResponseEntity.ok("Ok getExample !!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExampleResponse> getExample2(@PathVariable(value = "id") Long id) {
        // 여기에 비즈니스 로직을 추가하여 실제 응답을 생성합니다.
        ExampleResponse response = new ExampleResponse(id, "Example Data " + id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<ExampleResponse> postExample(@RequestBody ExampleRequest request) {
        Long id = request.getId();
        ExampleResponse response = new ExampleResponse(id, "Example Data " + id);
        return ResponseEntity.ok(response);
    }
}