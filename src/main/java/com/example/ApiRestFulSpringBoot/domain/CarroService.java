package com.example.ApiRestFulSpringBoot.domain;

import com.example.ApiRestFulSpringBoot.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService
{
    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros()
    {
        List<Carro> carros = rep.findAll();

        List<CarroDTO> list = new ArrayList<>();
        for (Carro c: carros)
        {
            list.add(new CarroDTO(c));
        }
        return list;
    }

    public Optional<CarroDTO> getCarroById(Long id)
    {
        Optional<Carro> carros = rep.findById(id);

        return rep.findById(id).map(CarroDTO::new);
    }

    public List<CarroDTO> getCarrosByTipo(String tipo)
    {
        List<Carro> carros = rep.findByTipo(tipo);

        List<CarroDTO> list = new ArrayList<>();
        for (Carro c: carros)
        {
            list.add(new CarroDTO(c));
        }
        return list;
    }

    public Carro save(Carro carro)
    {
        return rep.save(carro);
    }

    public CarroDTO update(Carro carro, Long id)
    {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        //Busca o carro no banco de dados
        Optional<CarroDTO> optional = getCarroById(id);
        if(optional.isPresent()) //verificando se ele existe
        {
            CarroDTO db = optional.get(); //pega o objeto do banco
            //Copiar as propriedades
            db.setNome(carro.getNome()); //salva o novo nome
            db.setTipo(carro.getTipo()); //salva o novo tipo
            System.out.println("Carro id: " +db.getId());

            //Atualiza o carro
            //rep.save(db);

            return db;
        }
        else //se o carro não existe, exibi a mensagem
        {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id)
    {
        if(getCarroById(id).isPresent()) // se o carro existir
        {
            rep.deleteById(id); //deleta o carro
        }
    }


}
