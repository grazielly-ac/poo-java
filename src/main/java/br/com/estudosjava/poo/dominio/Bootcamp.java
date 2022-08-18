package br.com.estudosjava.poo.dominio;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@EqualsAndHashCode
@Builder
public class Bootcamp {

    @Getter @Setter private String nome;
    @Getter @Setter private String descricao;
    @Getter private final LocalDate dataInicial = LocalDate.now();
    @Getter private final LocalDate dataFinal = dataInicial.plusDays(45);
    @Singular @Getter @Setter private Set<Dev> devsInscritos;
    @Getter private Set<Conteudo> conteudos;


}
