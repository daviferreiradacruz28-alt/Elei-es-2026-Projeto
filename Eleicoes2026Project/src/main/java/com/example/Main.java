package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Atributos
        Eleitor eleitor1 = new Eleitor();
        
        Candidato candidato1 = new Candidato("Bolsonaro", "PL", 22);
        Candidato candidato2 = new Candidato("Lula", "PT", 13);
        Candidato candidato3 = new Candidato("Cury", "AVANTE", 70);
        Candidato candidato4 = new Candidato("Renan Santos", "MBL", 14);
        Candidato candidato5 = new Candidato("Ronaldo Caiado", "PSD", 55);
        Candidato candidato6 = new Candidato("Zema", "NOVO", 30);
        Candidato candidato7 = new Candidato("Samara", "UP", 80);
        
        Urna urna = new Urna();
        urna.cadastrarCandidatos(candidato1);
        urna.cadastrarCandidatos(candidato2);
        urna.cadastrarCandidatos(candidato3);
        urna.cadastrarCandidatos(candidato4);
        urna.cadastrarCandidatos(candidato5);
        urna.cadastrarCandidatos(candidato6);
        urna.cadastrarCandidatos(candidato7);
        
        while (true) {
            System.out.println("============================");
            System.out.println("          Eleicoes        ");
            System.out.println("============================");
            
            System.out.println("1 - Me cadastrar\n2 - Ver meu perfil de eleitor\n3 - Ver candidatos\n4 - Votar\n5 - Ver resultados\n6 - Pesquisar\n0 - Sair");
            
            System.out.print("Digite uma opcao: ");
            int opcao = sc.nextInt();
            
            switch (opcao) {
                case 1:
                  eleitor1.cadastrar();
                break;
                
                case 2:
                  eleitor1.meusDados();
                break;
                
                case 3:
                  urna.listar();
                break;
                
                case 4:
                  urna.votar(eleitor1);
                break;
                
                case 5:
                  urna.seeResults();
                break;
                
                case 6:
                  urna.pesquisar();
                break;
                
                case 0:
                  System.out.println("Saindo...");
                  return;
                
                default:
                  System.out.println("Opcao invalida");
            }
        }
    }
}