package br.com.ti9.ti9workspaceapi.controller;

import br.com.ti9.ti9workspaceapi.dto.WorkspaceDTO;
import br.com.ti9.ti9workspaceapi.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/workspace/v1")
@RequiredArgsConstructor
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @GetMapping("/")
    public String todos(){

        return "Retorna todos os workspaces do usuário";
    }

    @GetMapping("/{workspaceId}")
    public ResponseEntity<WorkspaceDTO> buscar(@PathVariable UUID workspaceId){
        WorkspaceDTO workspace = workspaceService.buscar(workspaceId);

        return new ResponseEntity<>(workspace, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> registrar(@Validated @RequestBody WorkspaceDTO workspace){

        return new ResponseEntity<>(workspaceService.salvar(workspace), HttpStatus.OK);
    }

    // TODO: está alterando com o status 'inativo', verificar isso
    @PutMapping("/{workspaceId}")
    public ResponseEntity<WorkspaceDTO> alterar(@Validated @RequestBody WorkspaceDTO workspaceDTO, @PathVariable UUID workspaceId) {
        return new ResponseEntity<>(workspaceService.alterar(workspaceDTO, workspaceId), HttpStatus.OK);
    }

    @DeleteMapping("/{workspaceId}")
    public ResponseEntity<String> desativar(@PathVariable UUID workspaceId) {
        return new ResponseEntity<>(workspaceService.encerrar(workspaceId), HttpStatus.NO_CONTENT);
    }
}
