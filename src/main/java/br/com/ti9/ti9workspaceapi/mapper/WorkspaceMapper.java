package br.com.ti9.ti9workspaceapi.mapper;

import br.com.ti9.ti9workspaceapi.dto.WorkspaceDTO;
import br.com.ti9.ti9workspaceapi.model.Workspace;

public class WorkspaceMapper {

    public WorkspaceDTO toDTO(Workspace workspace) {

        WorkspaceDTO workspaceDTO = new WorkspaceDTO();

        workspaceDTO.setNome(workspace.getNome());
        workspaceDTO.setUri(workspace.getUri());

        return workspaceDTO;
    }
}
