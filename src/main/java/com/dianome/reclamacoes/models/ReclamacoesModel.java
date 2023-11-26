package com.dianome.reclamacoes.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


// Modelo da tabela de reclamações (nome do reclamante, telefone, descrição da reclamação, código de rastreamento e descrição da solução)

@Entity
@Table(name="TB_RECLAMACOES")
public class ReclamacoesModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer codigoRastreamento;
	
	private String nomeReclamante;
	
	private String telefoneReclamante;

	

	@Lob
	@Column(columnDefinition = "TEXT")
	private String descricaoReclamacao;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String descricaoSolucao;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeReclamante() {
		return nomeReclamante;
	}

	public void setNomeReclamante(String nomeReclamante) {
		this.nomeReclamante = nomeReclamante;
	}

	public String getTelefoneReclamante() {
		return telefoneReclamante;
	}

	public void setTelefoneReclamante(String telefoneReclamante) {
		this.telefoneReclamante = telefoneReclamante;
	}
	
	public Integer getCodigoRastreamento() {
		return codigoRastreamento;
	}

	public void setCodigoRastreamento(Integer codigoRastreamento) {
		this.codigoRastreamento = codigoRastreamento;
	}
	
		public String getDescricaoReclamacao() {
		return descricaoReclamacao;
	}

	public void setDescricaoReclamacao(String descricaoReclamacao) {
		this.descricaoReclamacao = descricaoReclamacao;
	}

	public String getDescricaoSolucao() {
		return descricaoSolucao;
	}

	public void setDescricaoSolucao(String descricaoSolucao) {
		this.descricaoSolucao = descricaoSolucao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
