package com.example.afrase.conteudo.service;

import com.example.afrase.conteudo.dao.TextRepository;
import com.example.afrase.conteudo.model.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TextService {

    @Autowired
    TextRepository textoRepository;

    private Map<Integer, Text> texts = new HashMap<>();
    private Integer proximoId=1;

    public Text cadastrar(Text texto){
        return textoRepository.save(texto);
       /*
        text.setId(proximoId);
        proximoId++;
        texts.put(text.getId(), text);
        return text;
        */
    }

    public Collection<Text> buscaTextos(){
        return textoRepository.findAll();
        //return texts.values();
    }

    public void excluir(Text texto){
        textoRepository.delete(texto);
        //texts.remove(texto.getId());
    }

    public Optional<Text> buscaTextoId(Integer id){
        return textoRepository.findById(id);
        //return texts.get(id);
    }

    public Text alterar(Text texto) {
        return textoRepository.save(texto);
        /*
        texts.put(texto.getId(), texto);
        return texto;
        */
    }

}
