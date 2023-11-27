package br.com.ti9.ti9workspaceapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String sobrenome;

    @Email
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;

    private String telefone;

    @NotNull
    @NotBlank
    private String senha;

    @OneToMany(mappedBy = "usuario",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
//    @JoinTable(name = "usuario_workspace",
//            joinColumns = { @JoinColumn(name = "usuario_id") },
//            inverseJoinColumns = { @JoinColumn(name = "workspace_id") }
//    )
    private Set<UsuarioWorkspace> workspaces = new HashSet<>();

    public void addWorkspace(Workspace workspace) {
        UsuarioWorkspace usuarioWorkspace = new UsuarioWorkspace(this, workspace);
        workspaces.add(usuarioWorkspace);
        workspace.getUsuarios().add(usuarioWorkspace);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Usuario that = (Usuario) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(sobrenome, that.sobrenome) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telefone, that.telefone) &&
                Objects.equals(criadoEm, that.criadoEm) &&
                Objects.equals(atualizadoEm, that.atualizadoEm) &&
                Objects.equals(encerradoEm, that.encerradoEm) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, email, status, criadoEm);
    }
}
