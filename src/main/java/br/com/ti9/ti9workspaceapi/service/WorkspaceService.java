package br.com.ti9.ti9workspaceapi.service;

import br.com.ti9.ti9workspaceapi.dto.WorkspaceDTO;
import br.com.ti9.ti9workspaceapi.mapper.WorkspaceMapper;
import br.com.ti9.ti9workspaceapi.model.Workspace;
import br.com.ti9.ti9workspaceapi.service.execption.DataNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ti9.ti9workspaceapi.repository.WorkspaceRespository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkspaceService {
	
	private final WorkspaceRespository workspaceRepository;
	private final WorkspaceMapper workspaceMapper;
	
	public String salvar(Workspace workspace) {
		workspaceRepository.save(workspace);

		return "Workspace criado";
	}

	public WorkspaceDTO buscar(UUID workspaceId){

		Workspace workspace = workspaceRepository
				.findById(workspaceId)
				.orElseThrow(() -> new DataNotFoundException("Workspace não encontrado."));

		return WorkspaceMapper.toDTO(workspace);
	}

	public WorkspaceDTO alterar(WorkspaceDTO workspace, UUID id){

		Workspace workspaceEncontrado = workspaceRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Workspace não encontrado."));

		workspaceEncontrado.setNome(workspace.getNome());
		workspaceEncontrado.setUri(workspace.getUri());
		workspaceEncontrado.setAtualizadoEm(LocalDateTime.now());
		// TODO: revisar os DTO, falta campos

		return workspaceMapper.toDTO(workspaceRepository.save(workspaceEncontrado));
	}

	public String encerrar(UUID id) {
		// TODO: verificar todo o procedimento para o encerramento de um workspace
		Workspace workspace = workspaceRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Workspace não encontrado."));
		workspace.setEncerradoEm(LocalDateTime.now());
		workspace.setStatus("inativo");

		workspaceRepository.save(workspace);

		return "Workspace encerrado";
	}
}
