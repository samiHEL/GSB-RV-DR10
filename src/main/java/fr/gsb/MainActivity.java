package fr.gsb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

import fr.gsb.rv.entites.Visiteur;
import com.android.volley.Request;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import fr.gsb.rv.modeles.ModeleGsb;
import fr.gsb.rv.technique.Session;

import static fr.gsb.rv.technique.Session.getSession;
import static fr.gsb.rv.technique.Session.ouvrir;

public class MainActivity extends AppCompatActivity {
    EditText etMatricule;
    EditText etMdp;
    TextView tvErreur;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMatricule = (EditText) findViewById(R.id.editTextTextPersonName);
        etMdp = (EditText) findViewById(R.id.editTextNumberPassword);
        tvErreur = (TextView) findViewById(R.id.erreur);

        Log.i("Creation", "Création de l'activité principale");


    }

    public void seConnecter(View vue) throws UnsupportedEncodingException {
        String matReq = null;
        String mdpReq = null;
        matReq = URLEncoder.encode(etMatricule.getText().toString(), "UTF-8");
        mdpReq = URLEncoder.encode(etMdp.getText().toString(), "UTF-8");
        String url = String.format("http://192.168.213.145:5000/visiteurs/%s/%s", matReq, mdpReq);
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


                    Intent intentEnvoyer = new Intent(MainActivity.this, MenuRvActivity.class);
                    startActivity( intentEnvoyer );
                }
                catch(JSONException e){
                    Log.e("Vis" , "Erreur JSON : " + e.getMessage());

                }
            }
        };
        Response.ErrorListener ecouteurErreur = new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Log.e("Vis" , "Erreur HTTP : " + error.getMessage());
            }

        };
        JsonObjectRequest requete = new JsonObjectRequest(
                Request.Method.GET ,
                url,
                null,
                ecouteurReponse,
                ecouteurErreur



        );
        RequestQueue fileRequetes = Volley.newRequestQueue(this);
        fileRequetes.add( requete);




    }

        /*HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            readStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }



        }*/




    public void annuler(View vue){
        Log.i("Initialisation", "Initialisation  des champs");
        etMatricule.setText("");
        etMdp.setText("");
    }


}