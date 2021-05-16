package fr.gsb.rv.technique;

import fr.gsb.rv.entites.Visiteur;

public class Session {
    private static Session session = null;
    private Visiteur visiteur;


    private Session(Visiteur leVisiteur) {
        super();
        this.visiteur = leVisiteur;

    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public static Session getSession() {

        return session;

    }

    public static void ouvrir(Visiteur leVisiteur) {
        if (session == null) {
            session = new Session(leVisiteur);
        }

    }

    public static void fermer() {
        session = null;
    }
}
