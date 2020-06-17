package com.aulonline.cursomc;

import com.aulonline.cursomc.dominio.Categoria;
import com.aulonline.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria informatica = new Categoria(null, "Informática");
        Categoria escritorio = new Categoria(null, "Escritório");

        categoriaRepository.saveAll(Arrays.asList(informatica, escritorio));
    }
}
