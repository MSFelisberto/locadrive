package br.com.fiap.locadrive.locadrive.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequestDTO(
        @NotNull(message = "ID não pode ser nulo")
        Long pessoaId,
        @NotNull(message = "ID não pode ser nulo")
        Long veiculoId,
        LocalDate dataInicio,
        LocalDate dataFim) {

}
