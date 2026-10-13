package com.example;
import java.util.Scanner;

public class Eleitor {
    Scanner sc = new Scanner(System.in);
    
    private String nome;
    private int idade;
    private String cep;
    private boolean cadastrado;
    private boolean jaVotou;
    
    public void cadastrar() {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        this.nome = nome;
        
        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        
        if (idade >= 16) {
            System.out.println("Voce pode votar!");
            this.idade = idade;
        } else {
            System.out.println("Voce nao pode votar, pois voce e menor de idade");
            return;
        }
        
        System.out.print("Digite seu cep: ");
        String cep = sc.nextLine();
        this.cep = cep;
        
        this.cadastrado = true;
        System.out.println("Cadastrado!");
    }
    
    public boolean getCadastrado() {
        return this.cadastrado;
    }
    
    public boolean getJaVotou() {
        return this.jaVotou;
    }
    
    public boolean virarTrueJaVotou() {
        return this.jaVotou = true;
    }
    
    public void meusDados() {
        System.out.println("============================");
        System.out.println("         Status       ");
        System.out.println("============================");
        
        if (cadastrado) {
            System.out.println("Nome: "+this.nome);
            System.out.println("Idade: "+this.idade);
            System.out.println("Cep: "+this.cep);
        } else {
            System.out.println("Informamos que voce nao tem nenhum titulo criado...\nCrie um para ter seus direitos");
        }
    }
}