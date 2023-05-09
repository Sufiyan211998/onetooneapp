package com.onetoone.controller;

import com.onetoone.payload.IdProofDto;
import com.onetoone.service.IdProofService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/idproof")
public class updateIdProofController {
    private IdProofService idProofService;

    public updateIdProofController(IdProofService idProofService) {
        this.idProofService = idProofService;
    }
@PutMapping("/{id}/pancardnumber")
    public ResponseEntity<IdProofDto> updateIdProof(@PathVariable long id, @RequestBody IdProofDto idProofDto){
        IdProofDto dto = idProofService.updateIdProof(id, idProofDto.getPancardnumber());
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
