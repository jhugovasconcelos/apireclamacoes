package com.dianome.reclamacoes.dtos;

import jakarta.validation.constraints.NotBlank;

public record SolucoesDto(@NotBlank String descricaoSolucao) {
}

