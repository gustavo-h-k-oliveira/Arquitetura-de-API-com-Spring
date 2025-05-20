package application.controller;

import application.model.Aluno;
import application.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> criarUsuario(@RequestBody Aluno aluno) {
        // Validação simples de senha (exemplo: mínimo 6 caracteres)
        if (aluno.getSenha() == null || aluno.getSenha().length() < 6) {
            return ResponseEntity.badRequest().build();
        }

        // Criptografa a senha e salva o usuário
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        aluno.setSenha(encoder.encode(aluno.getSenha()));
        Aluno salvo = alunoService.salvar(aluno);
        return ResponseEntity.ok(salvo);
    }
}
