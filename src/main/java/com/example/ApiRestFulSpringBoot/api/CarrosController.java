package com.example.ApiRestFulSpringBoot.api;

import com.example.ApiRestFulSpringBoot.domain.Carro;
import com.example.ApiRestFulSpringBoot.domain.CarroService;
import com.example.ApiRestFulSpringBoot.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
    @Autowired
    private CarroService service;

    @GetMapping()
    public ResponseEntity get()
    {
        return ResponseEntity.ok(service.getCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id)
    {
       Optional<CarroDTO> carro = service.getCarroById(id); //Optional se existe ou não
        return carro
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<CarroDTO>> getCarrosByTipo(@PathVariable("tipo") String tipo)
    {
        List<CarroDTO> carros = service.getCarrosByTipo(tipo);

        if(carros.isEmpty()) //Se a lista estiver vazia
        {
            return ResponseEntity.noContent().build();
        }
        else //Senão ela vai retornar a lista de carros
        {
            return ResponseEntity.ok(carros);
        }
    }
    @PostMapping
    public String post(@RequestBody Carro carro)
    {
        Carro c = service.save(carro);

        return "Carro salvo com sucesso, seu ID é: " +c.getId();
    }

    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Carro carro)
    {
        CarroDTO c = service.update(carro, id);

        return "Carro atualizado com sucesso, o ID do carro é:" +c.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id)
    {
        service.delete(id);

        return "Carro deletado com sucesso";
        
    }



}
