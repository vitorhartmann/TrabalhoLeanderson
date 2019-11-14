package Youtube;

public class Main { 

	 public static void main(String[] args) {
		Canal assunto = new Canal();

		Inscrito o1 = new Inscrito("Tânia Pinto Fernandes");
		Inscrito o2 = new Inscrito("Carlos Oliveira Cunha");
		Inscrito o3 = new Inscrito("Isabelle Martins Ribeiro");
		Inscrito o4 = new Inscrito("Miguel Araujo Castro");

		assunto.attach(o1);
		assunto.attach(o2);
		assunto.attach(o3);
		assunto.attach(o4);
		
		assunto.generateNewNumber();
		System.out.println("------");
		assunto.detach(o3);
		

		assunto.generateNewNumber();
		
	}
	
}
