package br.com.ti9.ti9workspaceapi.controller;

import br.com.ti9.ti9workspaceapi.dto.WorkspaceDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aplicacoes/v1")
public class AplicacaoController {

    @GetMapping("/")
    public String todos(){
        return "Retorna todas as aplicações do usuário";
    }

    @GetMapping("/{id}")
    public String buscar(@PathVariable UUID id){
        return "Retorna a aplicação " + id;
    }

    @PostMapping("/")
    public String registrar(@Validated @RequestBody WorkspaceDTO workspace){
        return "Cria uma aplicação";
    }

    @PutMapping("/{id}")
    public String alterar(@PathVariable UUID id, @RequestBody WorkspaceDTO workspaceDTO) {
        return "Altera uma aplicação.";
    }

    @DeleteMapping("/{id}")
    public String desativar(@PathVariable UUID id) {
        return "Desativa uma aplicação.";
    }
}
