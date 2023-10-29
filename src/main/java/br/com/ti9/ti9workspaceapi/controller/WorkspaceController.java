package br.com.ti9.ti9workspaceapi.controller;

import br.com.ti9.ti9workspaceapi.dto.WorkspaceDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/workspace/v1")
public class WorkspaceController {

    @GetMapping("/")
    public String todos(){
        return "Retorna todos os workspaces do usuário";
    }

    @GetMapping("/{id}")
    public String buscar(@PathVariable UUID id){
        return "Retorna o workspace " + id;
    }

    @PostMapping("/")
    public String registrar(@Validated @RequestBody WorkspaceDTO workspace){
        return "Cria um workspace";
    }

    @PutMapping("/{id}")
    public String alterar(@PathVariable UUID id, @RequestBody WorkspaceDTO workspaceDTO) {
        return "Altera um workspace";
    }

    @DeleteMapping("/{id}")
    public String desativar(@PathVariable UUID id) {
        return "Desativa um workspace";
    }
}
