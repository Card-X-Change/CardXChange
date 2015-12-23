package com.quockworks.cardxchange;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button buttonBrowseCards;
    private Button buttonExchangeCards;
    private Button buttonEditProfile;
    private ImageButton buttonImgBrowseCards;
    private ImageButton buttonImgExchangeCards;
    private ImageButton buttonImgEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonBrowseCards = (Button) findViewById(R.id.btnBrowseCards);
        buttonExchangeCards = (Button) findViewById(R.id.btnExchangeCards);
        buttonEditProfile = (Button) findViewById(R.id.btnEditProfile);

        buttonImgBrowseCards = (ImageButton) findViewById(R.id.ibnSeeCards);
        buttonImgExchangeCards = (ImageButton) findViewById(R.id.ibnExchange);
        buttonImgEditProfile = (ImageButton) findViewById(R.id.ibnEditProfile);

        buttonBrowseCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Coming soon!",Toast.LENGTH_LONG).show();
            }
        });

        buttonExchangeCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> pairs = new HashMap<String,String>();
                pairs.put("firstName","Michelle");
                pairs.put("lastName","Chang");
                exchange(pairs);
            }
        });

        buttonEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileTypeActivity.class);
                startActivity(intent);
            }
        });

        buttonImgBrowseCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Coming soon!",Toast.LENGTH_LONG).show();
            }
        });

        buttonImgExchangeCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> pairs = new HashMap<String,String>();
                pairs.put("firstName","Michelle");
                pairs.put("lastName","Chang");
                exchange(pairs);
            }
        });

        buttonImgEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileTypeActivity.class);
                startActivity(intent);
            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void exchange(HashMap<String,String> pairs){
        /*try {
            URL url = new URL("http://iotcardxchange.mybluemix.net/cardxchange");
            URLConnection conn = (URLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(pairs));
            writer.flush();
            writer.close();
            os.close();

            conn.connect();
        } catch (MalformedURLException e) {
            Toast.makeText(getApplicationContext(),"OMG ERRORZ",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            Toast.makeText(getApplicationContext(),"OMG",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (ProtocolException e) {
            Toast.makeText(getApplicationContext()," ERRORZ",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Z", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }*/
        JsonObject json = new JsonObject();
        json.addProperty("fromId", "1");
        json.addProperty("toId", "2");
        json.addProperty("firstName", "Brian");
        json.addProperty("lastName", "Quock");
        json.addProperty("skills", "Java, Android, Objective-C, iOS");

        Ion.with(this.getApplicationContext())
                .load("http://iotcardxchange.mybluemix.net/cardxchange")
                .setJsonObjectBody(json)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // do stuff with the result or error
                        String fullName = "";
                        if (result != null) {
                            for (Map.Entry<String, JsonElement> jsonEntry : result.entrySet()) {
                                if (jsonEntry.getKey().equals("firstName")) {
                                    fullName = jsonEntry.getValue().getAsString();
                                }
                                if (jsonEntry.getKey().equals("lastName") && fullName != "") {
                                    fullName = fullName + " " + jsonEntry.getValue().getAsString();
                                }
                            }
                            Toast.makeText(getApplicationContext(), fullName, Toast.LENGTH_LONG).show();
                        }
                        Toast.makeText(getApplicationContext(), "Exchange successful!", Toast.LENGTH_LONG).show();
                    }
                });
        Ion.with(this.getApplicationContext())
                .load("http://iotcardxchange.mybluemix.net/cardxchange")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // do stuff with the result or error
                        String fullName = "";
                        if (result != null) {
                            for (Map.Entry<String, JsonElement> jsonEntry : result.entrySet()) {
                                if (jsonEntry.getKey().equals("firstName")) {
                                    fullName = jsonEntry.getValue().getAsString();
                                }
                                if (jsonEntry.getKey().equals("lastName") && fullName != "") {
                                    fullName = fullName + " " + jsonEntry.getValue().getAsString();
                                }
                            }
                            Toast.makeText(getApplicationContext(), fullName, Toast.LENGTH_LONG).show();
                        }
                        Toast.makeText(getApplicationContext(), "BAM Connected!", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private String getQuery(HashMap<String,String> pairs) throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (String pair: pairs.keySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pairs.get(pair), "UTF-8"));
        }

        return result.toString();
    }
}
