import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RelogioDigital
{

    
    public static void main(String[] args) throws Exception
    {

        
            System.out.println(new SimpleDateFormat("H:m").format(new Date()));
            
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            
            String date = simpleDateFormat.format(new Date());
            System.out.println(date);

    }
}

