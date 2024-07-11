package com.springboot.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document
public class StudentData {

    @Id
    private String id;
    private String name;
    private String standard;
    private String address;
    private String fatherName;
    private String fatherPhone;

}
