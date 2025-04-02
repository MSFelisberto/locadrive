package br.com.fiap.locadrive.locadrive.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelRequestDTO(
        @Schema(description = "Id único da pessoa que esta alugando o veiculo")
        @NotNull(message = "ID não pode ser nulo")
        Long pessoaId,
        @NotNull(message = "ID não pode ser nulo")
        Long veiculoId,
        LocalDate dataInicio,
        LocalDate dataFim) {

}
