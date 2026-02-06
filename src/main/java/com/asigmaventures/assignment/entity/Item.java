package com.asigmaventures.assignment.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("items")
public class Item {

    @Id
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;
}
