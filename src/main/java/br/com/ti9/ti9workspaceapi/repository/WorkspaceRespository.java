package br.com.ti9.ti9workspaceapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ti9.ti9workspaceapi.model.Workspace;

@Repository
public interface WorkspaceRespository extends JpaRepository<Workspace, UUID> {

}
