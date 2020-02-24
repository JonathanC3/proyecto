package com.ucr.proyecto.converter;

import com.ucr.proyecto.domain.Issue;
import com.ucr.proyecto.dto.IssueDTO;
import org.springframework.stereotype.Service;

@Service
public class IssueRestConverter implements RestConverter<Issue, IssueDTO.Response, IssueDTO.Request> {
    @Override
    public IssueDTO.Response toResponse(Issue entity) {
        IssueDTO.Response dto = new IssueDTO.Response();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setRegisterTimestamp(entity.getRegisterTimestamp());
        dto.setAddress(entity.getAddress());
        dto.setContactPhone(entity.getContactPhone());
        dto.setContactEmail(entity.getContactEmail());
        dto.setComments(entity.getComments());
        dto.setSupportUserAssigned(entity.getSupportUser());
        return dto;
    }

    @Override
    public Issue fromRequest(IssueDTO.Request dto) {
        Issue entity= new Issue();
        entity.setDescription(dto.getDescription());
        entity.setRegisterTimestamp(dto.getRegisterTimestamp());
        entity.setAddress(dto.getAddress());
        entity.setContactPhone(dto.getContactPhone());
        entity.setContactEmail(dto.getContactEmail());
        entity.setComments(dto.getComments());
        entity.setSupportUser(dto.getSupportUserAssigned());
        return entity;
    }
}
