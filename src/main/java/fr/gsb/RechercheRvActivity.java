package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

public class RechercheRvActivity extends AppCompatActivity {
    Spinner mois;
    Spinner annee;
    private static final String[] lesMois={"Janvier" , "Fevrier" , "Mars" , "Avril" , "Mai" , "Juin" , "Juillet" , "Aout" , "Septembre" , "Octobre" ,"Novembre" , "Decembre"};
    private static final String[] lesAnnees={"2021" , "2020" , "2019" , "2018" , "2017" , "2016" , "2015" , "2014" , "2013" };
    Spinner spMois;
    Spinner spAnnees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_rv);
        spMois = ( Spinner ) findViewById(R.id.moisListe);
        spAnnees = ( Spinner ) findViewById(R.id.anneeListe);

        ArrayAdapter<String> aaMois = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                lesMois
        );
        ArrayAdapter<String> aaAnnees = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                lesAnnees
        );
        aaMois.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        aaAnnees.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        spMois.setAdapter( aaMois);
        spAnnees.setAdapter(aaAnnees);
    }


//mettre dans listeRV
    public void afficherListe(View vue) throws UnsupportedEncodingException {

        Intent intentEnvoyer = new Intent(RechercheRvActivity.this, ListeRvActivity.class);
        startActivity(intentEnvoyer);


    }
    public void retour(View vue) {

        Intent intentEnvoyer = new Intent(RechercheRvActivity.this, MenuRvActivity.class);
        startActivity(intentEnvoyer);
    }
}