/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasasf;

/**
 *
 * @author 15280420
 */
public class Carro {
    private int modelo;
    private String cor;
    private String numChassi;
    private boolean comArCondicionado;
    private boolean comAirbag;
    private boolean vidrosEletricos;

    public Carro(int modelo, String cor, String numChassi, boolean comArCondicionado, boolean comAirbag, boolean vidrosEletricos) {
        this.modelo = modelo;
        this.cor = cor;
        this.numChassi = numChassi;
        this.comArCondicionado = comArCondicionado;
        this.comAirbag = comAirbag;
        this.vidrosEletricos = vidrosEletricos;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNumChassi() {
        return numChassi;
    }

    public void setNumChassi(String numChassi) {
        this.numChassi = numChassi;
    }

    public boolean isComArCondicionado() {
        return comArCondicionado;
    }

    public void setComArCondicionado(boolean comArCondicionado) {
        this.comArCondicionado = comArCondicionado;
    }

    public boolean isComAirbag() {
        return comAirbag;
    }

    public void setComAirbag(boolean comAirbag) {
        this.comAirbag = comAirbag;
    }

    public boolean isVidrosEletricos() {
        return vidrosEletricos;
    }

    public void setVidrosEletricos(boolean vidrosEletricos) {
        this.vidrosEletricos = vidrosEletricos;
    }
    
    public double valorCarro(){
        double valor = 0;
        double arC = 0;
        double airB = 0;
        double vidro = 0;
        
        if(modelo == 1 || modelo == 2){
            valor = 35000;
        } else if(modelo == 3){
            valor = 42000;
        } else if(modelo == 4){
            valor = 53000;
        } else {
            valor = 60000;
        }
        
        if(comArCondicionado){
            arC = valor*(10/100);
        }
        
        if(comAirbag){
            airB = valor*(8/100);
        }
        
        if(vidrosEletricos){
            vidro = valor*(7/100);
        }
        
        valor = valor + arC + airB + vidro;
        
        return valor;
    }
    

    @Override
    public String toString() {
        String msg = "Modelo: "+modelo
                +"\nCor: "+cor
                +"\nNúmero de Chassi: "+numChassi;
        if(comArCondicionado){
            msg = msg + "\nArcondicionado: Sim";
        } else {
            msg = msg + "\nArcondicionado: Não";
        }
        
        if(comAirbag){
            msg = msg + "\nAir Bag: Sim";
        } else {
            msg = msg + "\nAir Bag: Não";
        }
        
        if(vidrosEletricos){
            msg = msg + "\nVidros Elétricos: Sim";
        } else {
            msg = msg + "\nVidros Elétricos: Não";
        }
        
        return msg;
    }
}
