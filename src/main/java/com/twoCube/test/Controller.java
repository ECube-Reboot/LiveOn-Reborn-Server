package com.twoCube.test;

import com.twoCube.couple.dto.Code;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/testing")
@RequiredArgsConstructor
@Api(tags = {"임시 API"})
public class Controller {

    @GetMapping("/test")
    @ApiOperation(value = "연동 테스트용 api")
    public ResponseEntity<TestDto> getTest(
//                                           @ApiIgnore @CurrentUser User user
    ){
        TestDto test = new TestDto();
        test.setText("성공");
        return ResponseEntity.ok(test);
    }

    @PostMapping("/test")
    @ApiOperation(value = "연동 테스트용 api")
    public ResponseEntity<Long> createTest(@RequestBody TestDto testDto
//                                           @ApiIgnore @CurrentUser User user
    ){
        System.out.println(testDto.getText());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/test/hasReturn")
    @ApiOperation(value = "연동 테스트용 api")
    public ResponseEntity<TestDto> postTest(@RequestBody TestDto testDto
//                                           @ApiIgnore @CurrentUser User user
    ){
        return ResponseEntity.ok(testDto);
    }

    @PostMapping("/image")
    @ApiOperation(value = "multipart/form데이터 연동 api", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<TestMultipartDto> createPolaroid(@RequestPart(required = false) MultipartFile image,
                                               @RequestPart(required = false) String content
//                                           @ApiIgnore @CurrentUser User user
    ) throws IOException {
        System.out.println("print");
        System.out.println(image.getOriginalFilename());
        return ResponseEntity.ok(
                new TestMultipartDto(image.getOriginalFilename(), content));
    }
}
