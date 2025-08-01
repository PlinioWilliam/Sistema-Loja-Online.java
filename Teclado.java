import java.io.*;

/** Classe que permite fazer leitura de dados do teclado */
public class Teclado
{
    private String s;
    private InputStreamReader i = new InputStreamReader (System.in);
    private BufferedReader d = new BufferedReader(i);

    /**
     Le um inteiro.
     @return int
     */
    public int leInt ()
    {
        int a = 0;
        try{
            s = d.readLine();
            a = Integer.parseInt(s);
        }
        catch (IOException e){
            System.out.println ("Erro de I/O: " + e);
        }
        catch (NumberFormatException e){
            System.out.println ("o valor digitado deve ser inteiro: "+e );
        }
        return (a);
    }

    /**
     Le um inteiro, com mensagem.
     @return int
     */
    public int leInt (String msg)
    {
        int a = 0;
        System.out.println(msg);
        try
        {
            s = d.readLine();
            a = Integer.parseInt(s);
        }
        catch (IOException e)
        {
            System.out.println ("Erro de I/O: "+e );
        }
        catch (NumberFormatException e)
        {
            System.out.println ("o valor digitado deve ser inteiro: "+e );
        }
        return (a);

    }

    /**
     Le um double.
     @return double
     */
    public double leDouble()
    {
        double a = 0;
        try
        {
            s = d.readLine();
            a = Double.parseDouble(s);
        }
        catch (IOException e)
        {
            System.out.println ("Erro de I/O: " + e);
        }
        catch (NumberFormatException e)
        {
            System.out.println ("o valor digitado deve ser numero: "+e );
        }
        return (a);
    }

    /**
     Le um double, com mensagem.
     @return double
     */
    public double leDouble(String msg)
    {
        double a = 0;
        System.out.println(msg);
        try
        {
            s = d.readLine();
            a = Double.parseDouble(s);
        }
        catch (IOException e)
        {
            System.out.println ("Erro de I/O: " + e);
        }
        catch (NumberFormatException e)
        {
            System.out.println ("o valor digitado deve ser numero: "+e );
        }
        return (a);
    }

    /**
     Le um string.
     @return String
     */
    public String leString()
    {
        s = "";
        try
        {
            s = d.readLine();

        }
        catch (IOException e)
        {
            System.out.println ("Erro de I/O: " + e);
        }
        return (s);
    }

    /**
     Le um string. com mensagem.
     @return String
     */
    public String leString(String msg)
    {
        s = "";
        System.out.println(msg);
        try
        {
            s = d.readLine();
        }
        catch (IOException e)
        {
            System.out.println ("Erro de I/O: " + e);
        }
        return (s);
    }

    /**
     Le um char.
     @return char
     */
    public char leChar()
    {
        s = "";
        char c=' ';
        try
        {
            s = d.readLine();
            c = s.charAt(0);
        }
        catch (IOException e)
        {
            System.out.println ("Erro de I/O: " + e);
        }
        return (c);
    }

    /**
     Le um char com mensagem.
     @return char
     */
    public char leChar(String msg)
    {
        s = "";
        char c=' ';
        System.out.println(msg);
        try
        {
            s = d.readLine();
            c = s.charAt(0);
        }
        catch (IOException e)
        {
            System.out.println ("Erro de I/O: " + e);
        }
        return (c);
    }

}
