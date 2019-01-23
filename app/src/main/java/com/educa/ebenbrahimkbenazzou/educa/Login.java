package com.educa.ebenbrahimkbenazzou.educa;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity {
    public static EditText txtLogin;
    public static String Password = "";
    public static Context mContext;
    int HTTPCODE = 0;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnOK, btnUndo;
    ImageView img1, img2, img3, img4, img5;
    ConstraintLayout constraintLayout;
    CheckBox remember;
    int cmp = 0;
    AlertDialog.Builder alert;
    View.OnClickListener ClickButtons = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
            try {
                switch (v.getId()) {
                    case R.id.btn0: {
                        ++cmp;
                        Password += btn0.getText().toString();
                        break;
                    }
                    case R.id.btn1: {
                        ++cmp;
                        Password += btn1.getText().toString();
                        break;
                    }
                    case R.id.btn2: {
                        ++cmp;
                        Password += btn2.getText().toString();
                        break;
                    }
                    case R.id.btn3: {
                        ++cmp;
                        Password += btn3.getText().toString();
                        break;
                    }
                    case R.id.btn4: {
                        ++cmp;
                        Password += btn4.getText().toString();
                        break;
                    }
                    case R.id.btn5: {
                        ++cmp;
                        Password += btn5.getText().toString();
                        break;
                    }
                    case R.id.btn6: {
                        ++cmp;
                        Password += btn6.getText().toString();
                        break;
                    }
                    case R.id.btn7: {
                        ++cmp;
                        Password += btn7.getText().toString();
                        break;
                    }
                    case R.id.btn8: {
                        ++cmp;
                        Password += btn8.getText().toString();
                        break;
                    }
                    case R.id.btn9: {
                        ++cmp;
                        Password += btn9.getText().toString();
                        break;
                    }
                    case R.id.btnUndo: {
                        if (cmp > 0) {
                            cmp--;
                            Password = Password.substring(0, Password.length() - 1);
                        } else {
                            cmp = 0;
                            Password = "";
                        }
                        Color();
                        break;
                    }
                    default: {
                        break;
                    }
                }
                Color();
                if (cmp < 5) {
                    btn0.setEnabled(true);
                    btn1.setEnabled(true);
                    btn2.setEnabled(true);
                    btn3.setEnabled(true);
                    btn4.setEnabled(true);
                    btn5.setEnabled(true);
                    btn6.setEnabled(true);
                    btn7.setEnabled(true);
                    btn8.setEnabled(true);
                    btn9.setEnabled(true);
                    btnUndo.setEnabled(true);
                    btnOK.setEnabled(false);
                } else {
                    btn0.setEnabled(false);
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnUndo.setEnabled(true);
                    btnOK.setEnabled(true);
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error : " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    };
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        isOnline();
        mContext = getApplicationContext();
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        remember = findViewById(R.id.chkRemember);
        constraintLayout = findViewById(R.id.constraint);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        btnOK = findViewById(R.id.btnOK);
        btnUndo = findViewById(R.id.btnUndo);
        txtLogin = findViewById(R.id.txtLogin);
        img1.setImageResource(R.drawable.grey);
        img2.setImageResource(R.drawable.grey);
        img3.setImageResource(R.drawable.grey);
        img4.setImageResource(R.drawable.grey);
        img5.setImageResource(R.drawable.grey);
        btn0.setOnClickListener(ClickButtons);
        btn1.setOnClickListener(ClickButtons);
        btn2.setOnClickListener(ClickButtons);
        btn3.setOnClickListener(ClickButtons);
        btn4.setOnClickListener(ClickButtons);
        btn5.setOnClickListener(ClickButtons);
        btn6.setOnClickListener(ClickButtons);
        btn7.setOnClickListener(ClickButtons);
        btn8.setOnClickListener(ClickButtons);
        btn9.setOnClickListener(ClickButtons);
        btnUndo.setOnClickListener(ClickButtons);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = findViewById(android.R.id.content);
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                try {
                    alert = new AlertDialog.Builder(Login.this)
                            .setTitle("Login")
                            .setIcon(R.drawable.authenticate);
                    findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                    try {
                        Thread t = new Thread() {
                            @Override
                            public void run() {
                                String sResponse = "Error";
                                HttpURLConnection myURLConnection = null;
                                try {
                                    //Configuration de la connexion
                                    URL url = new URL("http://test-angular.e-eduka.com/api/user/authenticate");
                                    myURLConnection = (HttpURLConnection) url.openConnection();
                                    //myURLConnection.setRequestProperty ("Authorization", "Basic " + Base64.encodeToString("dev:Demo@2019!".getBytes(), Base64.NO_WRAP));
                                    String basicAuth = "Basic " + Base64.encodeToString(("dev:Demo@2019!").getBytes(), Base64.NO_WRAP);
                                    myURLConnection.setRequestProperty("Authorization", basicAuth);
                                    myURLConnection.setRequestMethod("POST");
                                    myURLConnection.setRequestProperty("Content-Type", "application/json");
                                    myURLConnection.setConnectTimeout(15000);
                                    myURLConnection.setReadTimeout(10000);
                                    myURLConnection.setDoInput(true);
                                    myURLConnection.setDoOutput(true);

                                    JSONObject jsonParam = new JSONObject();
                                    jsonParam.put("username", txtLogin.getText());
                                    jsonParam.put("password", Password);

                                    OutputStreamWriter os = new OutputStreamWriter(myURLConnection.getOutputStream());
                                    os.write(jsonParam.toString());
                                    os.close();
                                    //Récupération du code réponse
                                    myURLConnection.connect();
                                    HTTPCODE = myURLConnection.getResponseCode();
                                    int iHttpStatus = myURLConnection.getResponseCode();
                                    InputStreamReader inStream;
                                    // Si le mot de passe & login sont corrèctes
                                    if (iHttpStatus == HttpURLConnection.HTTP_OK) {
                                        //Récupération de la réponse
                                        inStream = new InputStreamReader((myURLConnection.getInputStream()));
                                        BufferedReader buReader = new BufferedReader(inStream);

                                        StringBuilder sb = new StringBuilder();
                                        String output;
                                        while ((output = buReader.readLine()) != null) {
                                            sb.append(output);
                                        }
                                        sResponse = sb.toString();
                                        buReader.close();
                                        inStream.close();
                                        //Traitement de la réponse
                                        JSONObject jObject = new JSONObject(sResponse);
                                        JSONArray jsonArray = jObject.getJSONArray("user_information");
                                        Log.e("TAG", "JSON" + jObject.toString());
                                        JSONObject Object = jsonArray.getJSONObject(0);
                                        setPreferences("id_user", Object.get("id_user").toString());
                                        setPreferences("id_classe", Object.get("id_classe").toString());
                                        setPreferences("login_user", Object.get("login_user").toString());
                                        setPreferences("password", Object.get("password").toString());
                                        setPreferences("chemin_classe", Object.get("chemin_classe").toString());
                                        APIMatieres();
                                        startActivity(new Intent(Login.this, Home.class));
                                        finish();
                                    }
                                } catch (Exception e) {
                                    Log.e("TAG", "Connecting Failed : " + e.getMessage());
                                    //e.printStackTrace();
                                } finally {
                                    if (myURLConnection != null) {
                                        try {
                                            myURLConnection.disconnect();
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                }
                            }
                        };
                        t.start();
                    } catch (Exception e) {
                        Log.e("TAG", e.getMessage());
                    }
                } catch (Exception e) {
                    Log.e("TAG", e.getMessage());
                } finally {
                    if (HTTPCODE != HttpURLConnection.HTTP_OK)
                        Snackbar.make(constraintLayout, "غير قادر على العثور على هذا المستخدم", Snackbar.LENGTH_LONG).show();
                    findViewById(R.id.progressBar).setVisibility(View.GONE);
                }
            }
        });
        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    RememberMe(true);
                else
                    RememberMe(false);

            }
        });
    }

    public void Color() {
        switch (cmp) {
            case 0: {
                img1.setImageResource(R.drawable.grey);
                img2.setImageResource(R.drawable.grey);
                img3.setImageResource(R.drawable.grey);
                img4.setImageResource(R.drawable.grey);
                img5.setImageResource(R.drawable.grey);
                break;
            }
            case 1: {
                img1.setImageResource(R.drawable.blue);
                img2.setImageResource(R.drawable.grey);
                img3.setImageResource(R.drawable.grey);
                img4.setImageResource(R.drawable.grey);
                img5.setImageResource(R.drawable.grey);
                break;
            }
            case 2: {
                img1.setImageResource(R.drawable.blue);
                img2.setImageResource(R.drawable.blue);
                img3.setImageResource(R.drawable.grey);
                img4.setImageResource(R.drawable.grey);
                img5.setImageResource(R.drawable.grey);
                break;
            }
            case 3: {
                img1.setImageResource(R.drawable.blue);
                img2.setImageResource(R.drawable.blue);
                img3.setImageResource(R.drawable.blue);
                img4.setImageResource(R.drawable.grey);
                img5.setImageResource(R.drawable.grey);
                break;
            }
            case 4: {
                img1.setImageResource(R.drawable.blue);
                img2.setImageResource(R.drawable.blue);
                img3.setImageResource(R.drawable.blue);
                img4.setImageResource(R.drawable.blue);
                img5.setImageResource(R.drawable.grey);
                break;
            }
            case 5: {
                img1.setImageResource(R.drawable.blue);
                img2.setImageResource(R.drawable.blue);
                img3.setImageResource(R.drawable.blue);
                img4.setImageResource(R.drawable.blue);
                img5.setImageResource(R.drawable.blue);
                break;
            }
            default: {
                break;
            }
        }
    }

    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        //if no info recieved
        if (netInfo == null) {
            new AlertDialog.Builder(Login.this)
                    .setTitle("Internet")
                    .setMessage("No Internet Connection")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
            return false;
        } else {
            return true;
        }
    }

    public void Reset(View view) {
        cmp = 0;
        Password = "";
        img1.setImageResource(R.drawable.grey);
        img2.setImageResource(R.drawable.grey);
        img3.setImageResource(R.drawable.grey);
        img4.setImageResource(R.drawable.grey);
        img5.setImageResource(R.drawable.grey);
        ClickButtons.onClick(view);
        findViewById(R.id.progressBar).setVisibility(View.GONE);
    }

    private String getPreferences(String sPreference, String defValue) {
        preferences = mContext.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);
        return preferences.getString(sPreference, defValue);
    }

    private void setPreferences(String sPreference, String sValue) {
        preferences = mContext.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = preferences.edit();
        prefEditor.putString(sPreference, sValue);
        prefEditor.commit();
    }

    private void RememberMe(Boolean sValue) {
        preferences = mContext.getSharedPreferences("RememberMe", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = preferences.edit();
        prefEditor.putBoolean("remember", sValue);
        prefEditor.commit();
    }

    public void APIMatieres() {
        //Initialisation des variables
        Thread t = new Thread() {

            @Override
            public void run() {

                String sResponse = "Error";
                HttpURLConnection myURLConnection = null;
                try {
                    //Configuration de la connexion
                    URL url = new URL("http://test-angular.e-eduka.com/api/arbo/read_matiere");
                    myURLConnection = (HttpURLConnection) url.openConnection();
                    myURLConnection.setRequestProperty("Authorization", "Basic " + Base64.encodeToString(("dev:Demo@2019!").getBytes(), Base64.NO_WRAP));
                    myURLConnection.setRequestMethod("POST");
                    myURLConnection.setRequestProperty("Content-Type", "application/json");
                    myURLConnection.setConnectTimeout(15000);
                    myURLConnection.setReadTimeout(10000);
                    myURLConnection.setDoInput(true);
                    myURLConnection.setDoOutput(true);
                    JSONObject jsonParam = new JSONObject();
                    jsonParam.put("param", getPreferences("chemin_classe", "") + '4');
                    OutputStreamWriter os = new OutputStreamWriter(myURLConnection.getOutputStream());
                    os.write(jsonParam.toString());
                    os.close();

                    //Récupération du code réponse
                    myURLConnection.connect();
                    int iHttpStatus = myURLConnection.getResponseCode();
                    InputStreamReader inStream;
                    // Si le mot de passe & login sont corrèctes
                    if (iHttpStatus == HttpURLConnection.HTTP_OK) {

                        //Récupération de la réponse
                        inStream = new InputStreamReader((myURLConnection.getInputStream()));
                        BufferedReader buReader = new BufferedReader(inStream);
                        try {
                            StringBuilder sb = new StringBuilder();
                            String output;
                            while ((output = buReader.readLine()) != null) {
                                sb.append(output);
                            }
                            sResponse = sb.toString();
                        } finally {
                            buReader.close();
                            inStream.close();
                            myURLConnection.disconnect();
                        }

                        //Traitement de la réponse
                        JSONObject jObject = new JSONObject(sResponse);
                        JSONArray Object = jObject.getJSONArray("records");
                        for (int i = 0; i < Object.length(); i++) {
                            //  Home.arrayList.add(Object.getJSONObject(i));
                        }
                    } else {
                        Log.e("TAG", "Login Faild Response Code : " + myURLConnection.getResponseCode());
                    }

                } catch (Exception e) {
                    Log.e("TAG", e.getMessage());

                } finally {

                    if (myURLConnection != null) {
                        try {
                            myURLConnection.disconnect();
                        } catch (Exception ex) {
                        }
                    }
                }
            }
        };
        t.start();
    }
}