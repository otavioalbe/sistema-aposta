package com.example.sorteioservice.controller;

import com.example.sorteioservice.dto.ApostadorRequestDTO;
import com.example.sorteioservice.dto.ApostadorResponseDTO;
import com.example.sorteioservice.service.SorteioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/sorteio")
public class SorteioController {

    @Autowired
    private SorteioService sorteioService;

    @PostMapping("/apostar")
    public ResponseEntity<ApostadorResponseDTO> registraAposta(@RequestBody ApostadorRequestDTO dto){
        return sorteioService.salvarAposta(dto);
    }

    @GetMapping("/listar")
    public List<ApostadorResponseDTO> listarApostas(){
        return sorteioService.listarApostas();
    }

    @GetMapping("/executar-sorteio")
    public String executarSorteio(){
        return sorteioService.realizarSorteio();
    }

    @GetMapping("/reiniciar-aposta")
    public String reiniciarAposta(){
        return sorteioService.resetAposta();
    }

    @PostMapping("/premiacao")
    public ResponseEntity<String> premiacao(@RequestBody String cpf){
        return sorteioService.premiacao(cpf);
    }

}
