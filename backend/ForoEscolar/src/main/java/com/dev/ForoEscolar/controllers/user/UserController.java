package com.dev.ForoEscolar.controllers.user;

import com.dev.ForoEscolar.dtos.user.UserRequestDTO;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "Registra un nuevo usuario")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody @Valid UserRequestDTO userRegisterDataDTO) {
        UserResponseDTO user = userService.save(userRegisterDataDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todos los usuarios")
    public ResponseEntity<Iterable<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un usuario por su ID")
    public ResponseEntity<Optional<UserResponseDTO>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
