package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import fr.gsb.rv.entites.Visiteur;
import fr.gsb.rv.technique.Session;

import static fr.gsb.rv.technique.Session.getSession;

public class MenuRvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rv);
    }

    public void consulter(View vue) {
        Session.getSession().getVisiteur().getPrenom();
        Intent intentEnvoyer = new Intent(MenuRvActivity.this, RechercheRvActivity.class);
        startActivity(intentEnvoyer);
    }
    public void suivre(View vue){
        Session.getSession().getVisiteur().getPrenom();
        Intent intentEnvoyer1 = new Intent(MenuRvActivity.this, RechercheRvActivity.class);
        startActivity(intentEnvoyer1);
    }
}