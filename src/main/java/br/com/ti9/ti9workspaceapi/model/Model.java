package br.com.ti9.ti9workspaceapi.model;

import br.com.ti9.ti9workspaceapi.util.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
abstract class Model {

    @NotNull
    protected Status status = Status.ATIVO;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "criado_em")
    protected LocalDateTime criadoEm = LocalDateTime.now();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "atualizado_em")
    protected LocalDateTime atualizadoEm = LocalDateTime.now();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "encerrado_em")
    protected LocalDateTime encerradoEm;
}
