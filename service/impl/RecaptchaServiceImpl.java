package com.define.definepage.service.impl;

import com.define.definepage.service.RecaptchaService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class RecaptchaServiceImpl implements RecaptchaService {

    private final String RECAPTCHA_SECRET = "6LfwwhgqAAAAAMIIWJE7eI1NSu6ZLx_BJDAxCdva";
    private final String RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    @Override
    public boolean verifyRecaptcha(String recaptchaToken) {
        String response = "";
        JSONObject jsonObject = new JSONObject();

        try {
            URL urlObject = new URL(RECAPTCHA_VERIFY_URL);
            HttpsURLConnection connection = (HttpsURLConnection) urlObject.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            String param = "secret=" + RECAPTCHA_SECRET + "&response=" + recaptchaToken;

            DataOutputStream stream = new DataOutputStream(connection.getOutputStream());
            stream.writeBytes(param);
            stream.flush();
            stream.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                response += inputLine;
            }
            reader.close();
            JSONParser parser = new JSONParser();

            jsonObject = (JSONObject) parser.parse(response);

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        if ((boolean) jsonObject.get("success")) {
            return true;
        }

        return false;
    }
}
