package com.example.aluno.applicationrest;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebService
{
    public String post(String json)
    {
        try
        {
            //URL
            URL url = new URL("https://www.caelum.com.br/mobile");
            //estabeleçendo conecção
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Content-type","Application/json");
            connection.setRequestProperty("Aceept"      ,"Application/json");

            connection.setDoOutput(true);

            PrintStream output = new PrintStream(connection.getOutputStream());

            output.println(json);

            connection.connect();

            Scanner scanner = new Scanner(connection.getInputStream());

            String resposta = scanner.next();

            return resposta;

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

/*
    public String get()
    {

    }

    public String put()
    {

    }

    public String delete()
    {

    }
*/
}
