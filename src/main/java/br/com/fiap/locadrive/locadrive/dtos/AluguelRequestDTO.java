package br.com.fiap.locadrive.locadrive.dtos;

import java.time.LocalDate;

public record AluguelRequestDTO(Long pessoaId, Long veiculoId, LocalDate dataInicio, LocalDate dataFim) {

}
