package br.com.ti9.ti9workspaceapi.mapper;

import br.com.ti9.ti9workspaceapi.dto.WorkspaceDTO;
import br.com.ti9.ti9workspaceapi.model.Workspace;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceMapper {

    public WorkspaceDTO toDTO(Workspace workspace) {

        WorkspaceDTO workspaceDTO = new WorkspaceDTO();

        workspaceDTO.setNome(workspace.getNome());

        return workspaceDTO;
    }

    public Workspace toWorkspace(WorkspaceDTO workspaceDTO) {

        Workspace workspace = new Workspace();

        workspace.setNome(workspace.getNome());

        return workspace;
    }
}
