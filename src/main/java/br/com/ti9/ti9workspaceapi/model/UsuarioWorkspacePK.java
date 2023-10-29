package br.com.ti9.ti9workspaceapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Embeddable
@Getter
@Setter
public class UsuarioWorkspacePK {

    @Column(name = "id_usuario")
    private UUID idUsuario;
    @Column(name = "id_workspace")
    private UUID idWorkspace;
}
