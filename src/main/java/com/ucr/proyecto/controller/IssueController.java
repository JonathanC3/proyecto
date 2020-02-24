package com.ucr.proyecto.controller;

import com.ucr.proyecto.converter.IssueRestConverter;
import com.ucr.proyecto.domain.Issue;
import com.ucr.proyecto.dto.IssueDTO;
import com.ucr.proyecto.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/issues")
@CrossOrigin
public class IssueController {
    @Autowired
    private IssueService service;

    @Autowired
    private IssueRestConverter converter;
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public IssueDTO.Response findById(@PathVariable("id") Integer id ){
        return converter.toResponse(service.find(id));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public IssueDTO.Response save(@RequestBody IssueDTO.Request issue) {
        return converter.toResponse(service.save(converter.fromRequest(issue)));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public IssueDTO.Response update(@PathVariable("id") Integer id,
                                     @RequestBody IssueDTO.Request issue) {
        Issue toUpdate = converter.fromRequest(issue);
        toUpdate.setId(id);
        return converter.toResponse(toUpdate);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Integer id) {
        service.delete(id);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<IssueDTO.Response> findAll() {
        return service.findAll().stream().map(it -> converter.toResponse(it))
                .collect(Collectors.toList());
    }
}
