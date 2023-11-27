package br.com.ti9.ti9workspaceapi.service;

import br.com.ti9.ti9workspaceapi.dto.WorkspaceDTO;
import br.com.ti9.ti9workspaceapi.mapper.WorkspaceMapper;
import br.com.ti9.ti9workspaceapi.model.Usuario;
import br.com.ti9.ti9workspaceapi.model.Workspace;
import br.com.ti9.ti9workspaceapi.repository.WorkspaceRespository;
import br.com.ti9.ti9workspaceapi.service.execption.DataNotFoundException;
import br.com.ti9.ti9workspaceapi.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkspaceService {
	
	private final WorkspaceRespository workspaceRepository;
	private final WorkspaceMapper workspaceMapper;
	
	public String salvar(WorkspaceDTO workspaceDTO) {
		Workspace workspace = new Workspace();
		workspace.setNome(workspaceDTO.getNome());
		workspace.setStatus(Status.ATIVO);
		workspace.setAtualizadoEm(LocalDateTime.now());

		Usuario usuario =
		workspace.addUsuario(new Usuario());
		workspaceRepository.save(workspace);

		return "Workspace criado";
	}

	public WorkspaceDTO buscar(UUID workspaceId){

		Workspace workspace = workspaceRepository
				.findById(workspaceId)
				.orElseThrow(() -> new DataNotFoundException("Workspace não encontrado."));

		return workspaceMapper.toDTO(workspace);
	}

//	public WorkspaceDTO todosWorkspaces(UUID usuarioId){
//
//		Workspace workspace = workspaceRepository
//				.find(usuarioId)
//				.orElseThrow(() -> new DataNotFoundException("Workspace não encontrado."));
//
//		return workspaceMapper.toDTO(workspace);
//	}

	public WorkspaceDTO alterar(WorkspaceDTO workspaceDto, UUID workspaceId){

		Workspace workspaceEncontrado = workspaceRepository.findById(workspaceId).orElseThrow(() -> new DataNotFoundException("Workspace não encontrado."));

		workspaceEncontrado.setNome(workspaceDto.getNome());
		workspaceEncontrado.setAtualizadoEm(LocalDateTime.now());
		// TODO: revisar os DTO

		return workspaceMapper.toDTO(workspaceRepository.save(workspaceEncontrado));
	}

	public String encerrar(UUID workspaceId) {
		// TODO: verificar todo o procedimento para o encerramento de um workspace
		Workspace workspace = workspaceRepository.findById(workspaceId).orElseThrow(() -> new DataNotFoundException("Workspace não encontrado."));
		workspace.setEncerradoEm(LocalDateTime.now());
		workspace.setStatus(Status.INATIVO);

		workspaceRepository.save(workspace);

		return "Workspace encerrado";
	}
}
