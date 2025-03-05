package org.melogtm.imgprocessor.controllers;

import org.melogtm.imgprocessor.domain.user.AuthenticationDTO;
import org.melogtm.imgprocessor.domain.user.LoginResponseDTO;
import org.melogtm.imgprocessor.domain.user.RegisterDTO;
import org.melogtm.imgprocessor.domain.user.User;
import org.melogtm.imgprocessor.infra.security.TokenService;
import org.melogtm.imgprocessor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO info) throws Exception {
        var data_hash= new UsernamePasswordAuthenticationToken(info.username(), info.password());

        var auth = authenticationManager.authenticate(data_hash);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO info) {
        if (this.repository.findByUsername(info.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String crypt = passwordEncoder.encode(info.password());
        User user = new User(info.username(), crypt, info.role());

        this.repository.save(user);

        return ResponseEntity.ok().build();
    }


}
