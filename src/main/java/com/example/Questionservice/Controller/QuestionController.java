package com.example.Questionservice.Controller;

import com.example.Questionservice.DTO.QuestionRequestDTO;
import com.example.Questionservice.DTO.QuestionResponseDTO;
import com.example.Questionservice.DTO.QuestionUpdateRequestDTO;
import com.example.Questionservice.Service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@Slf4j
public class QuestionController {

    @Autowired
    QuestionService questionService;


    //create Question
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO){
        questionService.createQuestion(questionRequestDTO);
        return "Created successfully";
    }
    // update Question
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean updateQuestion(@PathVariable Long id, @RequestBody QuestionUpdateRequestDTO question){
        return questionService.updateQuestion(id, question);
    }
//    delete Question
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteQuestion(@PathVariable Long id){
        return questionService.deleteQuestion(id);
    }
//    read Question
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionResponseDTO> getQuestions(){
        return questionService.getQuestions();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuestionResponseDTO getQuestion(@PathVariable Long id){
        return questionService.getQuestion(id);
    }
}
