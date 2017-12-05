package mycollege.asmobisoft.com.restaurentapp.utility;

import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServiceCallMy {

    static String string;
    private static String responce = "";
    static HttpURLConnection urlConnection;
    public ServiceCallMy() {
    }

    public static String getJsonData(String urlFinal, String parameter) {
        try {
            URL m_url = new URL(urlFinal);
            HttpURLConnection conn = (HttpURLConnection)m_url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("content-type", "application/json");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            bw.write(parameter);
            bw.flush();
            bw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
            br.close();
            responce = sb.toString();
            Log.e("ServiceCall","responseString : "+responce);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return responce;
    }


    public static String getSignupData(String parameter, String strValue) throws JSONException {

        String urlFinal = "";
        if (strValue.equals("Signup")) {
            urlFinal = Constant.BASE_URL + Constant.METHOD_SIGNUP;
        } else if (strValue.equals("Login")) {
            urlFinal = Constant.BASE_URL + Constant.METHOD_SIGNUP;
        }
        Log.i("URL", urlFinal);
        responce = getJsonData(urlFinal, parameter);
        Log.i("requestSignup", responce);


        return responce;
    }

}