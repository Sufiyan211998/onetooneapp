package com.onetoone.payload;

import lombok.Data;

@Data
public class StudentDto {

    private Long id;

    private String name;

    private String course;

    private Double fee;

    private IdProofDto idProof;
}