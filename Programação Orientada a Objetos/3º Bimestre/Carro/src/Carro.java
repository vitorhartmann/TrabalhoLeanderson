public class Carro {

    private String marca;
    private String cor;
    private int ano;

    public Carro() {}

    public Carro(String marca, String cor, int ano) {
        setMarca(marca);
        setCor(cor);
        setAno(ano);
    }

    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }

    public int getAno(){
        return ano;
    }
    public void setAno(int ano){
        this.ano = ano;
    }

    public String toString(){
        return "[Carro {marca="
                +marca +", cor="
                +cor +", ano="
                +ano +"}]";

    }




}