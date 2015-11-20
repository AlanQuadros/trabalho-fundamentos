/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasasf;

import java.util.Scanner;

/**
 *
 * @author 15280420
 */
public class Fasasf {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Estacionamento est = new Estacionamento();
        Carro c;
        int modelo;
        String cor;
        String numChassi;
        boolean comArCondicionado;
        boolean comAirBag;
        boolean vidroEletrico;
        
        while (true) {            
            int op = menu();
            if(op == 0) break;
            
            switch(op){
                case 1:
                    System.out.print("Digite o modelo do carro: ");
                    String sMod = in.nextLine();
                    modelo = Integer.parseInt(sMod);
                    System.out.print("Digite a cor do carro: ");
                    cor = in.nextLine();
                    System.out.print("Digite o número de chassi do carro: ");
                    numChassi = in.nextLine();
                    System.out.print("Possui ar condicionado? (S/N): ");
                    String sArCond = in.nextLine();
                    if(sArCond.equalsIgnoreCase("s")){
                        comArCondicionado = true;
                    } else {
                        comArCondicionado = false;
                    }
                    
                    System.out.print("Possui air bag? (S/N): ");
                    String sAirB = in.nextLine();
                    if(sAirB.equalsIgnoreCase("s")){
                        comAirBag = true;
                    } else {
                        comAirBag = false;
                    }
                    
                    System.out.print("Possui vidros elétrico? (S/N): ");
                    String sVidEl = in.nextLine();
                    if(sVidEl.equalsIgnoreCase("s")){
                        vidroEletrico = true;
                    } else {
                        vidroEletrico = false;
                    }
                    
                    c = new Carro(modelo, cor, numChassi, comArCondicionado, comAirBag, vidroEletrico);
                    
                    est.carroVagaDisponivel(c);
                    
                    break;
            }
        }
    }
    
    public static int menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Escolha uma opção abaixo:");
        System.out.println("(0) Sair"
                + "\n(1) Adicionar carro"
                + "\n(2) Lugar do carro no estacionamento"
                + "\n(3) Mostrar quantidade de carros por modelo"
                + "\n(4) Soma total dos carros estacionados"
                + "\n(5) Remover carro"
                + "\n(6) Mostrar carro");
        System.out.print("Digite a opção: ");
        int op = in.nextInt();
        return op;
    }
    
}
