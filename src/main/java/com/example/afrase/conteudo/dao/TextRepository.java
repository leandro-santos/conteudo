package com.example.afrase.conteudo.dao;

import com.example.afrase.conteudo.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends JpaRepository<Text,Integer> {
}
