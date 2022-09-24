package com.example.Questionservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionUpdateRequestDTO {
    private String title;
    private String description;
    private List<CategoryDTO> categories;
}
