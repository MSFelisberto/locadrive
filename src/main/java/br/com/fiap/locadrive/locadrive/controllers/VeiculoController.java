package br.com.fiap.locadrive.locadrive.controllers;

import br.com.fiap.locadrive.locadrive.entities.Veiculo;
import br.com.fiap.locadrive.locadrive.services.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

//    http://localhost:8080/veiculos?page=1&size=10

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAllVeiculos(@RequestParam("page") int page, @RequestParam("size") int size) {
        logger.info("Endpoint: /veiculos foi acessado");
        var veiculos = this.veiculoService.findAllVeiculos(page, size);
        return ResponseEntity.ok(veiculos);
    }

    //    http://localhost:8080/veiculos/1

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findVeiculo(@PathVariable("id") Long id) {
        logger.info("/veiculos/" + id);
        var veiculo = this.veiculoService.findVeiculoById(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Void> saveVeiculo(@RequestBody Veiculo veiculo) {
        logger.info("POST -> /veiculos");
        this.veiculoService.saveVeiculo(veiculo);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVeiculo(@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
        logger.info("PUT -> /veiculos/" + id);
        this.veiculoService.updateVeiculo(veiculo, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable("id") Long id) {
        logger.info("DELETE -> /veiculos/" + id);
        this.veiculoService.deleteVeiculo(id);
        return ResponseEntity.noContent().build();
    }


}
