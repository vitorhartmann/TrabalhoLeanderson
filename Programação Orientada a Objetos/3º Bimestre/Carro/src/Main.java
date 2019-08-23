public class Main {

    public static void main(String[] args){

        Carro r1;
        r1 = new Carro();
        r1.setMarca("Toyota");
        r1.setCor("Azul");
        r1.setAno(2015);
        System.out.println(r1);

        Carro r2;
        r2 = new Carro();
        r2.setMarca("Volkswagen");
        r2.setCor("Preto");
        r2.setAno(2009);
        System.out.println(r2);

        Carro r3;
        r3 = new Carro();
        r3.setMarca("Chevrolet");
        r3.setCor("Vermelho");
        r3.setAno(2005);
        System.out.println(r3);
    }


}