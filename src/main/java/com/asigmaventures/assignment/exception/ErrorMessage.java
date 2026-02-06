package com.asigmaventures.assignment.exception;

import lombok.*;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ErrorMessage {
    private String code;
    private String title;
    private String message;
    private String[] values;
    private String origmesg;
    private Map<String, String> errors;
}
