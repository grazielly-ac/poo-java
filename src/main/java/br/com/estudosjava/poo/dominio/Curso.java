package br.com.estudosjava.poo.dominio;

import lombok.*;

@ToString(callSuper = true)
public class Curso extends Conteudo{

    @Getter @Setter private int cargaHoraria;

    @Builder
    public Curso(String titulo, String descricao, int cargaHoraria){
        super(titulo, descricao);
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO * cargaHoraria;
    }
}
