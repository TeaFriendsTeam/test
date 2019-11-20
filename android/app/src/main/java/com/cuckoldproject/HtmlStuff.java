package com.cuckoldproject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HtmlStuff {

    private String response;
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "http://kamiex.tech:8080/random";

    public void setResponse(String response){
        this.response = response;
    }
    public String getResponse(){
        return response;
    }

    public void sendGET() throws IOException{
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK){ //in case of success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            setResponse(response.toString());
        }else {
            System.out.println("That didn't work");
        }
    }
}
