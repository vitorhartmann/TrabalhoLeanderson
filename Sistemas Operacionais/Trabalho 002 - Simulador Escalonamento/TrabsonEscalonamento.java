import java.util.*;
 
public class TrabsonEscalonamento {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println ("Digite o numero de processos:");
		int n = sc.nextInt();
		int pid[] = new int[n];
		int at[] = new int[n]; // AT = ARRIVAL TIME        TEMPO DE CHEGADA
		int bt[] = new int[n]; // BT = BURST TIME       TEMPO DE EXECUÇÃO
		int ct[] = new int[n]; // CT = COMPLETE TIME     TEMPO ATÉ COMPLETAR
		int ta[] = new int[n]; // TA = TURN AROUND       
		int wt[] = new int[n];  // WT = WAITING TIME     TEMPO DE ESPERA
		int f[] = new int[n];  // F = CHECA SE O PROCESSO ACABOU OU NÃO
		int st=0, tot=0;
		float avgwt=0, avgta=0;
 
		for(int i=0;i<n;i++)
		{
			System.out.println ("Digite o tempo de chegada do processo (Arrival) " + (i+1) );
			at[i] = sc.nextInt();
			System.out.println ("Digite o tempo de execucao do processo (Burst) " + (i+1) );
			bt[i] = sc.nextInt();
			pid[i] = i+1;
			f[i] = 0;
		}
		
		boolean a = true;
		while(true)
		{
			int c=n, min=999;
			if (tot == n) // Numero total de processos
				break;
			
			for (int i=0; i<n; i++)
			{
				 // Um pouco de magia negra de repetição
				if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
				{
					min=bt[i];
					c=i;
				}
			}
			
		
			// Se C==N o valor de C não pode ser atualizado , por causa do arrival time < tempo do sistema, então aumentamos o tempo do sistema
			if (c==n) 
				st++;
			else
			{
				ct[c]=st+bt[c];
				st+=bt[c];
				ta[c]=ct[c]-at[c];
				wt[c]=ta[c]-bt[c];
				f[c]=1;
				tot++;
			}
		}
		
		System.out.println("\nID  Chegada Execucao  Completar TurnAround Espera");
		for(int i=0;i<n;i++)
		{
			avgwt+= wt[i];
			avgta+= ta[i];
			System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t   "+ct[i]+"\t     "+ta[i]+"\t      "+wt[i]);
		}
		System.out.println ("\nTempo de Turn Arount "+ (float)(avgta/n));
		System.out.println ("Tempo de Espera (Waiting Time) "+ (float)(avgwt/n));
		sc.close();
	}
}