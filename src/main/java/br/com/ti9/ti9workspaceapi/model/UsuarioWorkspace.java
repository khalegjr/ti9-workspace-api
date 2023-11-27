package br.com.ti9.ti9workspaceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity(name = "UsuarioWorkspace")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario_workspace")
public class UsuarioWorkspace extends Model {

    @EmbeddedId
    protected UsuarioWorkspacePK id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("usuarioId")
    private Usuario usuario;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId("workspaceId")
    private Workspace workspace;

    @Basic(optional = false)
    @Column(name = "proprietario")
    private boolean proprietario;

    public UsuarioWorkspace(Usuario usuario, Workspace workspace) {
        this.usuario = usuario;
        this.workspace = workspace;
        this.id = new UsuarioWorkspacePK(usuario.getId(), workspace.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UsuarioWorkspace that = (UsuarioWorkspace) o;
        return Objects.equals(usuario, that.usuario) &&
                Objects.equals(workspace, that.workspace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, workspace);
    }
}
