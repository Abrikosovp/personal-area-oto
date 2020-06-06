package com.example.personalareaoto.model;

//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "_question")
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonPropertyOrder(alphabetic = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question /*implements Serializable*/ {

    @Id
    @Column(name = "_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "_question")
    private String question;

    @Column(name = "_right_answer_id")
    private Integer rightAnswerId;

//    @Transient
//    @JacksonXmlProperty(localName = "child")
//    @JacksonXmlElementWrapper(useWrapping = false)
//    private Set<Map<String, Answers>> answers;

    @Transient
    private Set<Answers> answers;
}
