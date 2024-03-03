package com.example.developermaker.controller;

import com.example.developermaker.dto.response.DepartmentListDto;
import com.example.developermaker.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // REST api를 처리하는 컨트롤러
@RequestMapping("/api/departments") // 요청 URL
@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성자로 만들어줌
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping
    public ResponseEntity<?> getDepartments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(value = "name", required = false) String name

    ) {
        Page<DepartmentListDto> listDtos = departmentService.getDepartments(page, size, name);

        return new ResponseEntity<>(listDtos, HttpStatus.OK);
    }

}
