package com.example.Questionservice.Service;

import com.example.Questionservice.DTO.*;
import com.example.Questionservice.Model.Category;
import com.example.Questionservice.Model.Question;
import com.example.Questionservice.Repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public void createQuestion(QuestionRequestDTO questionRequestDTO){
        Question question = new Question();
        question.setTitle(questionRequestDTO.getTitle());
        question.setDescription(questionRequestDTO.getDescription());
        question.setCreated_date(LocalDate.now());
        question.setUserId(questionRequestDTO.getUserId());

        List<Category> categories =  questionRequestDTO.getCategories()
                        .stream().map(categoryDTO -> mapToCategory(categoryDTO)).toList();

        question.setCategories(categories);

        questionRepository.save(question);
    }

    public List<QuestionResponseDTO> getQuestions(){
        List<Question> questions = questionRepository.findAll();
        return questions.stream().map(question -> mapToQuestionResponse(question)).toList();
    }

    public QuestionResponseDTO getQuestion(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            return mapToQuestionResponse(question.get());
        }else {
            return null;
        }

    }

    public boolean deleteQuestion(Long id){
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateQuestion(Long id, QuestionUpdateRequestDTO question){
        Optional<Question> question1 = questionRepository.findById(id);
        if(question1.isPresent()){
            Question question2 = question1.get();
            question2.setCreated_date(LocalDate.now());
            if(question.getTitle() != null){
                question2.setTitle(question.getTitle());
            }
            if(question.getDescription() != null){
                question2.setDescription(question.getDescription());
            }
            if(question.getCategories()!=null && question.getCategories().size() > 0){
                List<Category> categories = question.getCategories().stream()
                        .map(categoryDTO -> mapToCategory(categoryDTO)).toList();
                question2.setCategories(categories);
            }

            questionRepository.save(question2);
            return true;
        }
        return false;
    }

    private QuestionResponseDTO mapToQuestionResponse(Question question){
        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
        questionResponseDTO.setId(question.getId());
        questionResponseDTO.setTitle(question.getTitle());
        questionResponseDTO.setDescription(question.getDescription());
        questionResponseDTO.setUserId(question.getUserId());
        List<CategoryResponseDTO> categoryResponseDTOS = question.getCategories().stream()
                        .map(this::mapToCategoryResponse).toList();
        questionResponseDTO.setCategories(categoryResponseDTOS);

        return questionResponseDTO;

    }

    private CategoryResponseDTO mapToCategoryResponse(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setName(category.getName());
        categoryResponseDTO.setId(category.getId());
        return categoryResponseDTO;
    }

    private Category mapToCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }

}
