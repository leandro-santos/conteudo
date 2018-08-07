package com.example.afrase.conteudo.service;

import com.example.afrase.conteudo.dao.TextRepository;
import com.example.afrase.conteudo.model.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TextService {

    final
    TextRepository textoRepository;

    @Autowired
    public TextService(TextRepository textoRepository) {
        this.textoRepository = textoRepository;
    }


    public Text cadastrar(Text texto){
        return textoRepository.save(texto);
    }

    public Collection<Text> buscaTextos(){
        return textoRepository.findAll();
    }

    public void excluir(Text texto){
        textoRepository.delete(texto);
    }

    public Optional<Text> buscaTextoId(Integer id){
        return textoRepository.findById(id);
    }

    public Text alterar(Text texto) {
        return textoRepository.save(texto);
    }

}
