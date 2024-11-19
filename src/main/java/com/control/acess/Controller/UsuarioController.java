package com.control.acess.Controller;

import com.control.acess.Config.UserDetailsImpl;
import com.control.acess.DTOS.LoginDto;
import com.control.acess.DTOS.RecoveryToken;
import com.control.acess.Models.Usuario;
import com.control.acess.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

        @Autowired
        private UsuarioService userService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
        public ResponseEntity<RecoveryToken> authenticateUser(@RequestBody LoginDto loginUserDto) {
            RecoveryToken token = userService.authenticateUser(loginUserDto);
            System.out.println(token);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        @GetMapping("/hello")
        public String Welcome() {
            return "Welcome";
        }

        @PostMapping("/")
        public ResponseEntity<Void> createUser(@RequestBody Usuario createUserDto) {
            userService.createUser(createUserDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        @GetMapping("/profile")
        public Usuario  getProfile() {
            return usuarioService.getProfile();
        }

}
