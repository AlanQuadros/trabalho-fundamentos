
package fasasf;

/**
 *
 * @author 15280420
 */
public class Estacionamento {
    private Carro estacionamento[][];

    public Estacionamento() {
        estacionamento = new Carro[500][50];
    }
    
    public boolean carroVagaDisponivel(Carro c){
        Carro aux;
        for (int i = 0; i < estacionamento.length; i++) {
            for (int j = 0; j < estacionamento.length; j++) {
                aux = estacionamento[i][j];
                if(aux == null){
                    estacionamento[i][j] = c;
                    return true;
                }
            }
        }
        return false;
    }
    
    public String posicaoCarro(String numChassi){
        String pos = "";
        for (int i = 0; i < estacionamento.length; i++) {
            for (int j = 0; j < estacionamento.length; j++) {
                if(estacionamento[i][j].getNumChassi().equalsIgnoreCase(numChassi)){
                    pos = "Carro na posição: ["+i+"]["+j+"]";
                    return pos;
                }
            }
        }
        return "Não foi encontrado nenhum carro!";
    }
    
    public Carro[] todosCarros(int m){
        Carro [] cs = new Carro[estacionamento.length*estacionamento[0].length];
        int indice = 0;
        for (int i = 0; i < estacionamento.length; i++) {
            for (int j = 0; j < estacionamento.length; j++) {
                if(m == estacionamento[i][j].getModelo()){
                    cs[indice] = estacionamento[i][j];
                    indice++;
                }
            }
        }
        if(indice < estacionamento.length*estacionamento[0].length){
            Carro[] carros = new Carro[indice];
            for (int i = 0; i < indice; i++) {
                carros[i] = cs[i];
            }
            return carros;
        }
        return cs;
    }
    
    public double somaCarros(){
        double soma = 0;
        for (int i = 0; i < estacionamento.length; i++) {
            for (int j = 0; j < estacionamento.length; j++) {
                soma = soma + estacionamento[i][j].valorCarro();
            }
        }
        return soma;
    }
    
    public boolean removeCarro(String numChassi){
        for (int i = 0; i < estacionamento.length; i++) {
            for (int j = 0; j < estacionamento.length; j++) {
                if(numChassi.equalsIgnoreCase(estacionamento[i][j].getNumChassi())){
                    estacionamento[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }
    
    public Carro verCarro(String numChassi){
        Carro c = null;
        for (int i = 0; i < estacionamento.length; i++) {
            for (int j = 0; j < estacionamento.length; j++) {
                if(numChassi.equalsIgnoreCase(estacionamento[i][j].getNumChassi())){
                    c = estacionamento[i][j];
                }
            }
        }
        return c;
    }
}
