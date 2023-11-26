package com.dianome.reclamacoes.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReclamacoesDto(@NotBlank String nomeReclamante,
		@NotNull Integer codigoRastreamento,
		@NotBlank String telefoneReclamante,
		@NotBlank String descricaoReclamacao
		) {
}

