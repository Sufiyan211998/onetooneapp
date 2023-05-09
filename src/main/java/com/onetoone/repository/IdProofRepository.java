package com.onetoone.repository;

import com.onetoone.entity.IdProof;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdProofRepository extends JpaRepository<IdProof,Long> {
}
