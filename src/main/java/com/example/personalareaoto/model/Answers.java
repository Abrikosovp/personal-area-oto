package com.example.personalareaoto.model;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(alphabetic = true)
public class Answers {

    private Integer id;

    private String text;

}