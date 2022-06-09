package com.twoCube.test;

import com.twoCube.couple.dto.Code;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/testing")
@RequiredArgsConstructor
public class Controller {

    @GetMapping("/test")
    @ApiOperation(value = "연동 테스트용 api")
    public ResponseEntity<TestDto> createNote(
//                                           @ApiIgnore @CurrentUser User user
    ){
        TestDto test = new TestDto();
        test.setText("성공");
        return ResponseEntity.ok(test);
    }
}
