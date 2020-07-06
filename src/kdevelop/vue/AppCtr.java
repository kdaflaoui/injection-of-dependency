package kdevelop.vue;

import kdevelop.dao.DaoImpl;
import kdevelop.dao.IDao;
import kdevelop.metier.MetierImpl;

public class AppCtr {

    public static void main (String [] args){

        //Principe d'injection des dependances

        //Créer une instance de la couche DAO
        IDao dao = new DaoImpl();

        // Créer une instance de la couche metier
        MetierImpl metier = new MetierImpl();

        //injecter la couche de DAO dans la couche metier
        metier.setDao(dao);

        System.out.println("La temperature obtenue est : " + metier.calcul_temperature());
    }
}
