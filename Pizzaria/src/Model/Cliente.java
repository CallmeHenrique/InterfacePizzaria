package Model;

public class Cliente {
    private String nome, endereco, telefone;
    
    public Cliente(String nome, String endereco, String telefone){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public String informacoes(){  
        String line = nome + " " + endereco + " " + telefone;
        return line;
    }
}
