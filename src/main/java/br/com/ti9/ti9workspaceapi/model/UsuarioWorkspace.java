package br.com.ti9.ti9workspaceapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario_workspace")
public class UsuarioWorkspace {

    @EmbeddedId
    protected UsuarioWorkspacePK usuarioWorkspacePK;

    @Basic(optional = false)
    @Column(name = "proprietario")
    private boolean proprietario;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    @JoinColumn(name = "id_workspace", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Workspace workspace;
}
