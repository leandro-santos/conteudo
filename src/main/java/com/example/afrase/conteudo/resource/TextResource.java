package com.example.afrase.conteudo.resource;

import com.example.afrase.conteudo.model.Text;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TextResource {

    Map<Integer, Text> texts;
    public Integer proximoId=1;

    private Text cadastrar(Text text){
        if (texts == null) {
            texts = new HashMap<>();
        }
        text.setId(proximoId);
        proximoId++;
        texts.put(text.getId(), text);
        return text;
    }

    private Collection<Text> buscaTextos(){
        return texts.values();
    }

    @RequestMapping(method= RequestMethod.GET, value="/texts")
    public void buscar() {
        return new ResponseEntity<Text>
    }

    @RequestMapping(method= RequestMethod.POST, value="/texts", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Text> cadastrarText(@RequestBody Text text){
        Text textCadastrado = cadastrar(text);
        System.out.println("chamou text post");
        System.out.println(textCadastrado);
        return new ResponseEntity<Text>(textCadastrado, HttpStatus.CREATED);
    }
}
