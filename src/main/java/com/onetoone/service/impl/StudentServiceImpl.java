package com.onetoone.service.impl;

import com.onetoone.entity.IdProof;
import com.onetoone.entity.Student;
import com.onetoone.payload.IdProofDto;
import com.onetoone.payload.StudentDto;
import com.onetoone.repository.IdProofRepository;
import com.onetoone.repository.StudentRepository;
import com.onetoone.service.StudentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private IdProofRepository idProofRepository;

    public StudentServiceImpl(StudentRepository studentRepository, IdProofRepository idProofRepository) {
        this.studentRepository = studentRepository;
        this.idProofRepository = idProofRepository;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        IdProof idProof = new IdProof();
        idProof.setId(studentDto.getId());
        idProof.setPancardnumber(studentDto.getIdProof().getPancardnumber());
        IdProof save = idProofRepository.save(idProof);

        Student student = new Student();
        student.setName(studentDto.getName());
        student.setCourse(studentDto.getCourse());
        student.setFee(studentDto.getFee());
        student.setIdProof(idProof);
        Student savestudent = studentRepository.save(student);

        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setCourse(student.getCourse());
        dto.setFee(student.getFee());

        IdProofDto dto1 = new IdProofDto();
        dto1.setId(idProof.getId());
        dto1.setPancardnumber(idProof.getPancardnumber());
        dto.setIdProof(dto1);
        return dto;
    }
}
