package com.example.afrase.conteudo.resource;

import com.example.afrase.conteudo.model.Text;
import com.example.afrase.conteudo.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class TextResource {

    final TextService textoService;

    @Autowired
    public TextResource(TextService textoService) {
        this.textoService = textoService;
    }

    @CrossOrigin
    @RequestMapping(method= RequestMethod.GET, value="/textos")
    public ResponseEntity<Collection<Text>> buscarTodosTextos() {
        Collection<Text> textos = textoService.buscaTextos();
        return new ResponseEntity<Collection<Text>>(textos, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method= RequestMethod.POST, value="/textos", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Text> cadastrarText(@RequestBody Text text){
        Text textCadastrado = textoService.cadastrar(text);
        return new ResponseEntity<Text>(textCadastrado, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(method= RequestMethod.DELETE, value="/textos/{id}")
    public ResponseEntity<Text> excluirTexto(@PathVariable Integer id){
        Optional<Text> optionalText = textoService.buscaTextoId(id);
        if (!optionalText.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Text texto = optionalText.get();
        textoService.excluir(texto);
        return new ResponseEntity<>(texto, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(method= RequestMethod.PUT, value="/textos")
    public ResponseEntity<Text> alterarTextos(@RequestBody Text texto){
        Text textoAlterado = textoService.alterar(texto);
        return new ResponseEntity<>(textoAlterado, HttpStatus.OK);
    }
}
