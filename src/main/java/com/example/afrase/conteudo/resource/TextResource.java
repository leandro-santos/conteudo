package com.example.afrase.conteudo.resource;

import com.example.afrase.conteudo.model.Text;
import com.example.afrase.conteudo.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TextResource {

    @Autowired
    TextService textoService;

    @CrossOrigin
    @RequestMapping(method= RequestMethod.GET, value="/textos")
    public ResponseEntity<Collection<Text>> buscarTodosTextos() {
        Collection<Text> textos = textoService.buscaTextos();
        return new ResponseEntity<Collection<Text>>(textos, HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.POST, value="/textos", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Text> cadastrarText(@RequestBody Text text){
        Text textCadastrado = textoService.cadastrar(text);
        return new ResponseEntity<Text>(textCadastrado, HttpStatus.CREATED);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/textos/{id}")
    public ResponseEntity<Text> excluirTexto(@PathVariable Integer id){
        Text texto = textoService.buscaTextoId(id).get();
        if (texto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        textoService.excluir(texto);
        return new ResponseEntity<>(texto, HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/textos")
    public ResponseEntity<Text> alterarTextos(@RequestBody Text texto){
        Text textoAlterado = textoService.alterar(texto);
        return new ResponseEntity<>(textoAlterado, HttpStatus.OK);
    }
}
