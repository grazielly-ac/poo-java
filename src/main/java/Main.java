
import br.com.estudosjava.poo.dominio.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {
        Curso java = Curso.builder()
                .titulo("Curso de Java para iniciantes")
                .descricao("Aprendizado com Maven, Lombok e Java 11")
                .cargaHoraria(10)
                .build();
        System.out.printf("XP curso java %.2f%n", java.calcularXP());
        Curso javascript = Curso.builder()
                .titulo("Curso de Javascript para iniciantes")
                .descricao("Aprendendo Javascript para uso com Frameworks Front-End")
                .cargaHoraria(14)
                .build();
        System.out.printf("XP curso javascript %.2f%n", javascript.calcularXP());

       Mentoria mentoriaJava = Mentoria.builder()
                .titulo("Mentoria curso Java")
                .descricao("Apoio no conteúdo de Lombok, Maven e Java")
                .data(LocalDate.now())
                .build();
        System.out.printf("XP mentoria java %.2f%n", mentoriaJava.calcularXP());

        Conteudo mentoriaJavascript = Mentoria.builder()
                .titulo("Mentoria Javascript")
                .descricao("Criando o parte Front-End com Javascript")
                .data(LocalDate.now())
                .build();
        System.out.printf("XP mentoria javascript %.2f%n", mentoriaJavascript.calcularXP());

        Set<Conteudo> cursosMentoria = new HashSet<>();
        cursosMentoria.add(java);
        cursosMentoria.add(javascript);
        cursosMentoria.add(mentoriaJava);
        cursosMentoria.add(mentoriaJavascript);

        Bootcamp bootcamp = Bootcamp.builder()
                .nome("Programação Orientada a Objetos Java")
                .descricao("Reforço a respeito de POO com Lombok e Maven")
                .conteudos(cursosMentoria)
                .build();


        Set<Dev> devs = new LinkedHashSet<>();
        devs.add(Dev.builder().nome("Grazielly").build());
        devs.add(Dev.builder().nome("Elaine").build());
        devs.add(Dev.builder().nome("Pedro").build());

        devs.forEach((valor) -> {
            valor.inscreverBootcamp(bootcamp);
        });
        bootcamp.setDevsInscritos(devs);
        System.out.println(bootcamp.getDevsInscritos().size());

        Dev dev = devs.stream().findFirst().get();
        dev.progredir();
        dev.progredir();
        dev.progredir();
        dev.progredir();
        dev.progredir();
        System.out.println(dev.calcularTotalXP());

        devs.stream().forEach(v -> {
            if(v.getNome().equals("Elaine")){
                v.progredir();
                v.progredir();
                v.progredir();
                System.out.println(v.calcularTotalXP());
            }
        });
    }
}
