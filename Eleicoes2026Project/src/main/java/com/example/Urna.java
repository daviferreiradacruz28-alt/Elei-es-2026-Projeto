package com.example;
import java.util.Scanner;

public class Urna {
    Scanner sc = new Scanner(System.in);
    
    private int count;
    private int nulo;
    
    Candidato[] candidatos = new Candidato[7];
    
    public void cadastrarCandidatos(Candidato c) {
        this.candidatos[this.count] = c;
        this.count++;
    }
    
    public void listar() {
        System.out.println("============================");
        System.out.println("           Candidatos         ");
        System.out.println("============================");
        
        if (this.count == 0) {
            System.out.println("Nao ha nenhum candidato cadastrado...");
            return;
        } else {
            for(int i = 0; i < candidatos.length; i++) {
                System.out.println("Nome: "+candidatos[i].getNome()+"| Partido: "+candidatos[i].getPartido()+" | Numero: "+candidatos[i].getNumero());
                System.out.println("--------------------------------");
            }
        }
    }
    
    public void votar(Eleitor eleitorRecebe) {
        if (this.count == 0) {
            System.out.println("Nenhum candidato cadastrado");
            return;
        }
        if (eleitorRecebe.getCadastrado() && !eleitorRecebe.getJaVotou()) {
            System.out.println("============================");
            System.out.println("         Votar        ");
            System.out.println("============================");
        
            listar();
        
            System.out.println("Digite o numero de seu candidato: ");
            int chooseNumber = sc.nextInt();
        
            boolean candidatoFound = false;
            
            for(int i = 0; i < candidatos.length; i++) {
                if (candidatos[i].getNumero() == chooseNumber) {
                    candidatos[i].ganhouVoto();
                    
                    candidatoFound = true;
                    
                    eleitorRecebe.virarTrueJaVotou();
                    
                    System.out.println("Tan dan dan... VOTOU!");
                }
            }
            
            if (candidatoFound == false) {
                this.nulo++;
                eleitorRecebe.virarTrueJaVotou();
                
                System.out.println("Tan dan dan... VOTOU!");
            }
        } else {
            System.out.println("Voce nao se cadastrou ainda ou ja votou... Crie uma conta para votar");
        }
    }
    
    public void seeResults() {
        if (this.count == 0) {
            System.out.println("Nenhum candidato cadastrado");
            return;
        } else {
            System.out.println("============================");
            System.out.println("         Resultados       ");
            System.out.println("============================");
            
            Candidato candidatoMaior = candidatos[0];
            
            for(int i = 0; i < candidatos.length; i++) {
                System.out.println("Nome: "+candidatos[i].getNome());
                System.out.println("Partido: "+candidatos[i].getPartido());
                System.out.println("Numero: "+candidatos[i].getNumero());
                System.out.println("Votos: "+candidatos[i].getVotos());
                
                System.out.println("----------------------------");
                
                if (candidatos[i].getVotos() > candidatoMaior.getVotos()) {
                    candidatoMaior = candidatos[i];
                }
            }
            System.out.print("Candidato ganhador: ");
            System.out.println(candidatoMaior.getNome());
            System.out.println("Votos: "+candidatoMaior.getVotos());
            System.out.println("Partido: "+candidatoMaior.getPartido());
            System.out.println("Numero: "+candidatoMaior.getNumero());
                
            System.out.println("Votos nulos: "+this.nulo);
        }
    }
    
    public void pesquisar() {
        if (this.count == 0) {
            System.out.println("Nenhum candidato cadastrado");
            return;
        } else {
            System.out.println("============================");
            System.out.println("         Pesquisar        ");
            System.out.println("============================");
            
            System.out.print("Pesquise o nome do seu candidato: ");
            String pesquisar = sc.nextLine();
            
            for(int i = 0; i < candidatos.length; i++) {
                if (pesquisar.equalsIgnoreCase(candidatos[i].getNome())) {
                    System.out.println("Nome: "+candidatos[i].getNome());
                    System.out.println("Partido: "+candidatos[i].getPartido());
                    System.out.println("Numero: "+candidatos[i].getNumero());
                }
            }
        }
    }
}