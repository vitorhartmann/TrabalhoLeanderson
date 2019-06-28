import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Calendario
{

    
    public static void main(String[] args) throws Exception
    {
        System.out.println("       ");
        System.out.println("     Calendario");
            System.out.println("_____________________");
            System.out.println("Dia     Mes     Ano");
            String padrao = "dd      MM      yyyy";
            SimpleDateFormat formatadata = new SimpleDateFormat(padrao);
            
            String data = formatadata.format(new Date());
            System.out.println(data);

    }
}

