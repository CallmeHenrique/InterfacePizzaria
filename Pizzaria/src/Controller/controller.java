package Controller;
import java.util.ArrayList;
import View.*;
import Model.*;
public class controller {
    private Principal p;
    private Historico h;
    private NumeroPedido n;
    private Ingredientes i;
    private String saborI;
    private ArrayList<String> ing = new ArrayList<>();
    private static int identificador = 1;
    
    public controller(Principal p, Historico h, NumeroPedido n, Ingredientes i){
        this.p = p;
        this.h = h;
        this.n = n;
        this.i = i;
        ingredientes();
    }
    
    public controller(NumeroPedido n){
        this.n = n;
    }
    
    public controller(Ingredientes i){
        this.i = i;
    }
    
    public void ingredientes(){
        String fCatupiry = "Massa\nMolho de tomate\nFrango\nCatupiry";
        String queijo = "Massa\nMolho de tomate\nQueijo";
        String atum = "Massa\nMolho de tomate\nAtum";
        String fCheddar = "Massa\nMolho de tomate\nFrango\nCheddar";
        String portuguesa = "Massa\nMolho de tomate\nQueijo\nPresunto\nOvo";
        String calabresa = "Massa\nMolho de tomate\nCalabresa";
        
        ing.add(fCatupiry);
        ing.add(queijo);
        ing.add(atum);
        ing.add(fCheddar);
        ing.add(portuguesa);
        ing.add(calabresa);
    }
    
    public String informacoes(){
        String nome = p.getNome().getText();
        String endereco = p.getEndereco().getText();
        String telefone = p.getTelefone().getText();
        
        Cliente C = new Cliente(nome, endereco, telefone);
        
        return C.informacoes();
    }
    
    public String pizza(String sabor){
        String tamanho = p.getTamanho().getSelectedItem().toString();
        
        Pizza P = new Pizza(tamanho, sabor);

        return P.pizza();
    }
    
    public void exibirDisplay(String sabor){
        if(p.getDisplay().getText().isEmpty() == true){
            p.getDisplay().setText(informacoes() + "\n" + pizza(sabor));
        }else{
            String t = p.getDisplay().getText();
            p.getDisplay().setText(t + "\n" + pizza(sabor));
        }
        this.saborI = sabor;
    }
    
    public void concluirPedido(){
        if(h.getHistorico().getText().isEmpty() == true){
            h.getHistorico().setText(identificador + " " + p.getDisplay().getText());
        }else{
            String t = h.getHistorico().getText();
            h.getHistorico().setText(t + "\n\n" + identificador + " " + p.getDisplay().getText());
        }
        
        p.getDisplay().setText("");
        p.getNome().setText("");
        p.getEndereco().setText("");
        p.getTelefone().setText("");
        
        n.getPedido().setText("Pedido número: " + identificador);
        identificador++;
        n.setVisible(true);
    }
    
    public void exibirIngredientes(){
        i.setVisible(true);
        
        if(saborI.equals("Frango com Catupiry")){
            i.getLista().setText(ing.get(0));
        }else if(saborI.equals("Queijo")){
            i.getLista().setText(ing.get(1));
        }else if(saborI.equals("Atum")){
            i.getLista().setText(ing.get(2));
        }else if(saborI.equals("Frango com Cheddar")){
            i.getLista().setText(ing.get(3));
        }else if(saborI.equals("Portuguesa")){
            i.getLista().setText(ing.get(4));
        }else if(saborI.equals("Calabresa")){
            i.getLista().setText(ing.get(5));
        }
    }
    
    public void Ok(){
        n.dispose();
    }
    
    public void OkI(){
        i.dispose();
    }
    
    public void exibirHistorico(){
        h.setVisible(true);
    }
    
    
}
