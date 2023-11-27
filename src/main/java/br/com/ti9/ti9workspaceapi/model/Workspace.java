package br.com.ti9.ti9workspaceapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity(name = "Workspace")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "workspace")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Workspace extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @NotNull
    private String nome;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
//    @JoinTable(name = "usuario_workspace",
//            joinColumns = { @JoinColumn(name = "workspace_id") },
//            inverseJoinColumns = { @JoinColumn(name = "usuario_id") }
//    )
    private Set<UsuarioWorkspace> usuarios = new HashSet<>();

    public Workspace(String nome) {
        this.nome = nome;
    }

    public void addUsuario(Usuario usuario) {
        UsuarioWorkspace usuarioWorkspace = new UsuarioWorkspace(usuario, this);
        usuarios.add(usuarioWorkspace);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Workspace that = (Workspace) o;
        return Objects.equals(nome, that.nome) &&
                Objects.equals(criadoEm, that.criadoEm) &&
                Objects.equals(atualizadoEm, that.atualizadoEm) &&
                Objects.equals(encerradoEm, that.encerradoEm) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, status, criadoEm);
    }
}
