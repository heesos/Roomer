package com.roomer.app.testPackage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Getter
@Setter
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/getTests")
    public ResponseEntity<List<TestPOJO>> getAllTestPOJOs() {
        List<TestPOJO> testPOJOList = testRepository.findAll();
        return new ResponseEntity<>(testPOJOList, HttpStatus.OK);
    }
}
