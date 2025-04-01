package br.com.fiap.locadrive.locadrive.dtos;

import java.util.List;

public record ValidationErrorDTO(List<String> erros, int status) {
}
