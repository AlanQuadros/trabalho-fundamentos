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

          while (true) {
               int op = menu();
               if (op == 0) {
                    break;
               }

               switch (op) {
                    case 1:
                         adicionaCarro(est);
                         break;
                    case 2:
                         lugarCarro(est);
                         break;
                    case 3:
                         carrosPorModelo(est);
                         break;
                    case 4:
                         System.out.println("Soma dos preços dos carros: "+est.somaValoresCarros());
                         break;
                    case 5:
                         removerCarroEstacionado(est);
                         break;
                    case 6:
                         mostrarCarroEstacionado(est);
                         break;
               }
          }
     }

     public static void adicionaCarro(Estacionamento est) {
          Scanner in = new Scanner(System.in);
          System.out.print("Digite o modelo do carro: ");
          String sMod = in.nextLine();
          int modelo = Integer.parseInt(sMod);
          System.out.print("Digite a cor do carro: ");
          String cor = in.nextLine();
          System.out.print("Digite o número de chassi do carro: ");
          String numChassi = in.nextLine();
          System.out.print("Possui ar condicionado? (S/N): ");
          String sArCond = in.nextLine();
          boolean comArCondicionado;
          if (sArCond.equalsIgnoreCase("s")) {
               comArCondicionado = true;
          } else {
               comArCondicionado = false;
          }

          boolean comAirBag;
          System.out.print("Possui air bag? (S/N): ");
          String sAirB = in.nextLine();
          if (sAirB.equalsIgnoreCase("s")) {
               comAirBag = true;
          } else {
               comAirBag = false;
          }

          boolean vidroEletrico;
          System.out.print("Possui vidros elétrico? (S/N): ");
          String sVidEl = in.nextLine();
          if (sVidEl.equalsIgnoreCase("s")) {
               vidroEletrico = true;
          } else {
               vidroEletrico = false;
          }

          Carro c = new Carro(modelo, cor, numChassi, comArCondicionado, comAirBag, vidroEletrico);

          if(est.carroVagaDisponivel(c)){
               System.out.println("Carro adicionado com sucesso!");
          } else {
               System.out.println("Estacionamento cheio!");
          }
     }
     
     public static void lugarCarro(Estacionamento est){         
          Scanner in = new Scanner(System.in);
          System.out.print("Digite o número de chassi do carro: ");
          String numChassi = in.nextLine();
          System.out.println(est.posicaoCarro(numChassi));
     }
     
     public static void carrosPorModelo(Estacionamento est){
          Scanner in = new Scanner(System.in);
          int modelo = 0;
          while(true){
               System.out.print("Digite o modelo: ");
               modelo = in.nextInt();
               if(modelo <= 0 || modelo >= 6){
                    System.out.println("DIGITE UM MODELO VÁLIDO (1 AO 5)!");
               } else {
                    break;
               }
          }
          System.out.println(est.todosCarrosPorModelo(modelo));
          
     }
     
     public static void removerCarroEstacionado(Estacionamento est){
          Scanner in = new Scanner(System.in);
          System.out.print("Digite o número de chassi do veículo: ");
          String numChassi = in.nextLine();
          
          if(est.removeCarro(numChassi)){
               System.out.println("Veículo removido!");
          } else {
               System.out.println("Veículo não encontrado!");
          }
     }
     
     public static void mostrarCarroEstacionado(Estacionamento est){
          Scanner in = new Scanner(System.in);
          System.out.print("Digite o número de chassi do veículo: ");
          String numChassi = in.nextLine();
          
          if(est.verCarro(numChassi)== null){
               System.out.println("Carro não encotrado!");
          } else {
               System.out.println(est.verCarro(numChassi));
          }
     }
     
     public static int menu() {
          Scanner in = new Scanner(System.in);
          System.out.println("Escolha uma opção abaixo:");
          System.out.println("(0) Sair"
                  + "\n(1) Adicionar carro"
                  + "\n(2) Lugar do carro no estacionamento"
                  + "\n(3) Mostrar todos os carros pelo modelo"
                  + "\n(4) Soma total dos carros estacionados"
                  + "\n(5) Remover carro"
                  + "\n(6) Mostrar dados do carro");
          System.out.print("Digite a opção: ");
          int op = in.nextInt();
          return op;
     }

}
