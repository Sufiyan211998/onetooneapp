package com.onetoone.service.impl;

import com.onetoone.entity.IdProof;
import com.onetoone.exception.IdProofNotFoundException;
import com.onetoone.payload.IdProofDto;
import com.onetoone.repository.IdProofRepository;
import com.onetoone.service.IdProofService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
@Service
public class IdProofServiceImpl implements IdProofService {
 private    IdProofRepository idProofRepository;

    public IdProofServiceImpl(IdProofRepository idProofRepository) {
        this.idProofRepository = idProofRepository;
    }

    @Override
    public IdProofDto updateIdProof(Long id, String pancardnumber) {
        IdProof idProof = idProofRepository.findById(id).orElseThrow(
                () -> new IdProofNotFoundException("no record found")
        );
        idProof.setPancardnumber(pancardnumber);
        IdProof updateIdProof = idProofRepository.save(idProof);

        IdProofDto dto = new IdProofDto();
        dto.setId(updateIdProof.getId());
        dto.setPancardnumber(updateIdProof.getPancardnumber());
        return dto;
    }
}
