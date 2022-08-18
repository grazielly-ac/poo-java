package br.com.estudosjava.poo.dominio;

import lombok.*;

import java.util.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos;
    @Singular private Set<Conteudo> conteudosConcluidos;


    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos = new LinkedHashSet<>();
        this.conteudosInscritos.addAll(bootcamp.getConteudos());

        System.out.printf("%s se inscreveu nos conteúdos: %s%n", this.getNome(), this.conteudosInscritos);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();

        if(conteudo.isPresent()) {
            if(conteudosConcluidos.size() == 0){
            this.conteudosConcluidos = new HashSet<>();
            }
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        System.out.printf("Ainda falta %d cursos para %s%n", this.getConteudosInscritos().size(), this.getNome());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }

    }

    public String calcularTotalXP(){
        double somaXP = this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXP).sum();
        return String.format("XP total adquirido = %.2f", somaXP);
    }
}
