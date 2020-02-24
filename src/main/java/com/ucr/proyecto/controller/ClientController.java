package com.ucr.proyecto.controller;


import com.ucr.proyecto.converter.ClientRestConverter;
import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.dto.ClientDTO;
import com.ucr.proyecto.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/api/clients")
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientService service;

    @Autowired
    private ClientRestConverter converter;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ClientDTO.Response findById(@PathVariable("id") Integer id ){
        return converter.toResponse(service.find(id));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ClientDTO.Response save(@RequestBody ClientDTO.Request client) {
        return converter.toResponse(service.save(converter.fromRequest(client)));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ClientDTO.Response update(@PathVariable("id") Integer id,
                                    @RequestBody ClientDTO.Request client) {
        Client toUpdate = converter.fromRequest(client);
        toUpdate.setId(id);
        return converter.toResponse(toUpdate);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Integer id) {
        service.delete(id);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<ClientDTO.Response> findAll() {
        return service.findAll().stream().map(it -> converter.toResponse(it))
                .collect(Collectors.toList());
    }


}
