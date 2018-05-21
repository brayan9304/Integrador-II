package com.integrador.service.mapper;

import com.integrador.domain.*;
import com.integrador.service.dto.ProfessorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Professor and its DTO ProfessorDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProfessorMapper extends EntityMapper <ProfessorDTO, Professor> {
    
    @Mapping(target = "courses", ignore = true)
    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Professor toEntity(ProfessorDTO professorDTO); 
    default Professor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Professor professor = new Professor();
        professor.setId(id);
        return professor;
    }
}
