package com.dianome.reclamacoes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dianome.reclamacoes.dtos.ReclamacoesDto;
import com.dianome.reclamacoes.dtos.SolucoesDto;
import com.dianome.reclamacoes.models.ReclamacoesModel;
import com.dianome.reclamacoes.repositories.ReclamacoesRepository;

import jakarta.validation.Valid;

@RestController
public class ReclamacoesController {
	
	@Autowired    // Realiza a injeção de dependência
	ReclamacoesRepository reclamacaoRepository;
	
	@GetMapping("/reclamacoes")  // Faz a listagem de todas as reclamações
	public ResponseEntity<List<ReclamacoesModel>> listarReclamacoes(){
		List<ReclamacoesModel> reclamacoesList = reclamacaoRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(reclamacoesList);
	}
	
	@PostMapping("/reclamacoes")   // Aqui, o usuário cria uma nova reclamação com código de rastreio, nome, telefone e descrição
	public ResponseEntity<ReclamacoesModel> novaReclamacao(@RequestBody @Valid ReclamacoesDto reclamacaoDto){
		var reclamacaoModel = new ReclamacoesModel();
		BeanUtils.copyProperties(reclamacaoDto, reclamacaoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(reclamacaoRepository.save(reclamacaoModel));
	}
	
	
	@PutMapping("/solucoes/{id}")  // Aqui, a empresa pega a reclamação pelo id e posta a solução
	public ResponseEntity<Object> postarSolucao(@PathVariable(value="id") Integer id, 
											@RequestBody @Valid SolucoesDto solucaoDto) {										
		Optional<ReclamacoesModel> reclamacao = reclamacaoRepository.findById(id);
		if(reclamacao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reclamação não encontrada");
		}
		var reclamacaoModel = reclamacao.get();
		BeanUtils.copyProperties(solucaoDto, reclamacaoModel);
		return ResponseEntity.status(HttpStatus.OK).body(reclamacaoRepository.save(reclamacaoModel));
	}
	
	@PutMapping("/reclamacoes/{id}")  // Aqui, o usuário pode atualizar os dados da reclamação postada pelo id
	public ResponseEntity<Object> atualizarReclamacao(@PathVariable(value="id") Integer id, 
											@RequestBody @Valid ReclamacoesDto reclamacaoDto) {										
		Optional<ReclamacoesModel> reclamacao = reclamacaoRepository.findById(id);
		if(reclamacao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reclamação não encontrada");
		}
		var reclamacaoModel = reclamacao.get();
		BeanUtils.copyProperties(reclamacaoDto, reclamacaoModel);
		return ResponseEntity.status(HttpStatus.OK).body(reclamacaoRepository.save(reclamacaoModel));
	}
	
	@GetMapping("/reclamacoes/{id}")  // Aqui, é possível encontrar uma reclamação específica pelo seu id
	public ResponseEntity<Object> encontrarReclamacao(@PathVariable(value="id") Integer id){
		Optional<ReclamacoesModel> reclamacao = reclamacaoRepository.findById(id);
		if(reclamacao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reclamação não encontrada");
		}
		return ResponseEntity.status(HttpStatus.OK).body(reclamacao.get());
		
	}
	
	@DeleteMapping("/reclamacoes/{id}")  // Aqui, é possível excluir uma reclamação pelo seu id
	public ResponseEntity<Object> apagarReclamacao(@PathVariable(value="id") Integer id){
		Optional<ReclamacoesModel> reclamacao = reclamacaoRepository.findById(id);
		if(reclamacao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("reclamação não encontrada");
		}
		reclamacaoRepository.delete(reclamacao.get());
		return ResponseEntity.status(HttpStatus.OK).body("Reclamação excluída com sucesso");
	}
}
