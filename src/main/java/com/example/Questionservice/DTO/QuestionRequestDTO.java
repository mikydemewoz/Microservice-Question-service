package com.example.Questionservice.DTO;

import com.example.Questionservice.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequestDTO {
    private String title;
    private String description;
    private Long userId;
    private List<CategoryDTO> categories;
}
