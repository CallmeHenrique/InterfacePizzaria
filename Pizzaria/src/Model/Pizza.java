package Model;

public class Pizza {
    private String tamanho, sabor;
    private double valor;
    
    public Pizza(String tamanho, String sabor){
        this.tamanho = tamanho;
        this.sabor = sabor;
        if(tamanho.equals("P")){
            this.valor = 20.0;
        }else if(tamanho.equals("M")){
            this.valor = 23.0;
        }else{
            this.valor = 29.0;
        }
    }
    
    public String pizza(){
        String line = sabor + " " + tamanho + " " + valor + " reais";
        return line;
    }

    public String getSabor() {
        return sabor;
    }
}
