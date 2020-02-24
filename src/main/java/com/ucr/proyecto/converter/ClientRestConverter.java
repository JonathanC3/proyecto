package com.ucr.proyecto.converter;

import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.dto.ClientDTO;
import org.springframework.stereotype.Service;

@Service
public class ClientRestConverter implements RestConverter<Client, ClientDTO.Response, ClientDTO.Request>{
    @Override
    public ClientDTO.Response toResponse(Client entity) {
        ClientDTO.Response dto = new ClientDTO.Response();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setFirstSurname(entity.getFirstSurname());
        dto.setSecondSurname(entity.getSecondSurname());
        dto.setAddress(entity.getAddress());
        dto.setPassword(entity.getPassword());
        dto.setPhone(entity.getPhone());
        dto.setSecondContact(entity.getSecondContact());
        dto.setEmail(entity.getEmail());
        dto.setServices(entity.getServices());
        return dto;
    }

    @Override
    public Client fromRequest(ClientDTO.Request dto) {
        Client entity = new Client();
        entity.setName(dto.getName());
        entity.setFirstSurname(dto.getFirstSurname());
        entity.setSecondSurname(dto.getSecondSurname());
        entity.setAddress(dto.getAddress());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());
        entity.setSecondContact(dto.getSecondContact());
        entity.setEmail(dto.getEmail());
        entity.setServices(dto.getServices());
        return entity;
    }
}
