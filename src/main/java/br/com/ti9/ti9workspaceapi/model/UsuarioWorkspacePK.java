package br.com.ti9.ti9workspaceapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioWorkspacePK implements Serializable {

    @Column(name = "id_usuario")
    private UUID idUsuario;
    @Column(name = "id_workspace")
    private UUID idWorkspace;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UsuarioWorkspacePK that = (UsuarioWorkspacePK) o;
        return Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idWorkspace, that.idWorkspace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idWorkspace);
    }
}
