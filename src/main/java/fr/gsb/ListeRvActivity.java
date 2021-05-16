package fr.gsb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

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

/*public class ListeRvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);


        Spinner mois = null;
        Spinner annee = null;
        mois = (Spinner) findViewById(R.id.moisListe);
        annee = (Spinner) findViewById(R.id.anneeListe);
        String url = String.format("http://192.168.213.145:5000/Rapports/%s/%s/$s", Session.getSession().getVisiteur().getMatricule(), mois, annee);
        Response.Listener<JSONObject> ecouteurReponse = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Visiteur unVisiteur = new Visiteur();
                    unVisiteur.setMatricule(response.getString("vis_matricule"));
                    unVisiteur.setNom(response.getString("vis_nom"));
                    unVisiteur.setPrenom(response.getString("vis_prenom"));
                    Log.i("Vis", String.valueOf(unVisiteur));
                    Session.ouvrir(unVisiteur);
                    Log.i("Matricule", Session.getSession().getVisiteur().getMatricule());
                    Log.i("Prenom", Session.getSession().getVisiteur().getPrenom());
                    Log.i("Nom", Session.getSession().getVisiteur().getNom());


                } catch (JSONException e) {
                    Log.e("Vis", "Erreur JSON : " + e.getMessage());

                }
            }

        };
        Response.ErrorListener ecouteurErreur = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Vis", "Erreur HTTP : " + error.getMessage());
            }

        };
        JsonObjectRequest requete = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                ecouteurReponse,
                ecouteurErreur


        );
        RequestQueue fileRequetes = Volley.newRequestQueue(this);
        fileRequetes.add(requete);
    }
    public void retourListeS(View vue) {

        Intent intentEnvoyer = new Intent(ListeRvActivity.this, RechercheRvActivity.class);
        startActivity(intentEnvoyer);
    }
}*/


public class ListeRvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        //

        String[] produits = {"Liste 1", "Liste 2", "Liste 3", "Liste 4"};


        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a ListView with simple ListItem (Only one TextView).

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , produits);

        listView.setAdapter(arrayAdapter);
    }
    public void retourListeS(View vue) {

        Intent intentEnvoyer = new Intent(ListeRvActivity.this, RechercheRvActivity.class);
        startActivity(intentEnvoyer);
    }
    public void afficherListe(View vue) throws UnsupportedEncodingException {

        Intent intentEnvoyer = new Intent(ListeRvActivity.this, RechercheRvActivity.class);
        startActivity(intentEnvoyer);


    }
    
}
