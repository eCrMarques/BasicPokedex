import java.util.Scanner;
import java.util.ArrayList;

class Celular {
    boolean lig=false;
    String[] correio = {"Oi 1", "Tchau 2"};
    String[] musica = {"Musica 1", "Musica 2",};
    String musicaAtual=musica[0];
    ArrayList<String> Navegador = new ArrayList<String>(); 
    String abaAtual="Aba 1";
    Scanner Scan = new Scanner(System.in);
    int op;
    void tocarMusica() {
        System.out.println("Tocando "+this.musicaAtual);
    }
    void pausarSom() {
        System.out.println("Pausando "+this.musicaAtual);
    }
    void selecionarSom() {
        
        for (int i=0; i<this.musica.length; i++){
        System.out.println("Selecione "+(i+1)+" Para tocar : "+this.musica[i]);
        }
        this.op = this.Scan.nextInt();
        switch(this.op){
            case 1:
                this.musicaAtual=this.musica[0];
                break;
            case 2:
                this.musicaAtual=this.musica[1];
                break;
        }
        System.out.println("Musica Atual: "+this.musicaAtual);
        
    }
    void ligar() {
        if(this.lig==false){
            System.out.println("Ligando..");
            this.lig=true;
        }else{
        System.out.println("Desligando..");
        this.lig=false;
        }
    }
    void atender() {
        if(this.lig==true){
            System.out.println("ligacao em andamento 1-para desligar e 2- para continuar");
            this.op=this.Scan.nextInt();
            switch(this.op){
                case 1:
                    System.out.println("ligacao encerrada");
                    this.lig=false;
                    break;
                case 2:
                    System.out.println("continuando ligacao");
                    this.lig=true;
                    break;
            }
            
        }else{
        System.out.println("ligacao atendida");
        this.lig=true;
        }
    }
    void iniciarCorreioVoz() {
        System.out.println("voce tem "+this.correio.length+" mensagem");
        for (int i=0; i<this.correio.length; i++){
        System.out.println("mensagem "+i+" : "+this.correio[i]);
        }
    }
    void exibirPagina() {
        if(this.Navegador.size()<1){
            this.Navegador.add("Aba 1");
        }
        System.out.println("voce esta na "+this.abaAtual);
        for (String i : this.Navegador) {
      System.out.println("Aba "+i+" Disponivel\n");
    }
    }
    void adicionarNovaAba() {
        System.out.println("Escolha um nome para a Aba\n");
        String aba = Scan.nextLine();
        this.Navegador.add(aba);
        System.out.println(aba+" Adicionada");
    }
    void atualizarPagina() {
        System.out.println("Aba atualizada");
        this.abaAtual=this.Navegador.get(0);
    }
}
class main {
    public static void main(String[] args) {
        Celular Iphone = new Celular();
        
        //System.out.println("Metodo Tocar Musica");
        //Iphone.tocarMusica();
        
        //System.out.println("Metodo Pausar");
        //Iphone.pausarSom();
        
        //System.out.println("Metodo Selecionar Som");
        //Iphone.selecionarSom();
        
        //System.out.println("Metodo Ligar");
        //Iphone.ligar();
        
        //System.out.println("Metodo Atender");
        //Iphone.atender();
        
        //System.out.println("Metodo Correio");
        //Iphone.iniciarCorreioVoz();
        
        //System.out.println("Metodo Exibir Pagina");
        //Iphone.exibirPagina();
        
        //System.out.println("Metodo Adicionar Nova Aba");
        //Iphone.adicionarNovaAba();
        
        //System.out.println("Metodo Atualizar Pagina");
        //Iphone.atualizarPagina();

    }
}