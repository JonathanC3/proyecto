package com.ucr.proyecto.controller.security;


import com.ucr.proyecto.dto.security.LoginDTO;
import com.ucr.proyecto.dto.security.RegisterClientDTO;
import com.ucr.proyecto.dto.security.UserDTO;
import com.ucr.proyecto.exceptions.security.InvalidCredentialsException;
import com.ucr.proyecto.service.security.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping(method = RequestMethod.POST, path = "/api/login")
    public UserDTO login(@RequestBody LoginDTO user) {

        if (sessionService.validateUser(user.getUserName(), user.getPassword())) {
            String token = sessionService.buildToken(user.getUserName());
            UserDTO result = new UserDTO();
            result.setUser(user.getUserName());
            result.setToken(token);
            return result;
        }
        throw new InvalidCredentialsException();

    }

    @RequestMapping(method = RequestMethod.POST, path = "/api/register")
    public void register(@RequestBody RegisterClientDTO register) {
        sessionService.createUser(register);
    }
}