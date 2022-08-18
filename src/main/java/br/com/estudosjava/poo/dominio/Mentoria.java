package br.com.estudosjava.poo.dominio;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@ToString(callSuper = true)
@SuperBuilder
public class Mentoria extends Conteudo{


    @Getter @Setter private LocalDate data;

    @Override
    public double calcularXP() {
        return XP_PADRAO + 20d;
    }
}
