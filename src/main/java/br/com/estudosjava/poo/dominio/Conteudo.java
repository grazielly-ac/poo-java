package br.com.estudosjava.poo.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@ToString
public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    @Getter @Setter private String titulo;
    @Getter @Setter private String descricao;

    public abstract double calcularXP();
}
