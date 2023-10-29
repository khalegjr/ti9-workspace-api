package br.com.ti9.ti9workspaceapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

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
    private String email;

    private String telefone;

    @NotNull
    @NotBlank
    private String senha;

    private LocalDateTime atualizadoEm;
    private LocalDateTime encerradoEm;

    @NotNull
    private String status = "ativo";

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioWorkspace> usuarioWorkspaceList = new ArrayList<>();

}
