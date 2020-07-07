package kdevelop.vue;

import kdevelop.dao.DaoImpl;
import kdevelop.dao.IDao;
import kdevelop.metier.IMetier;
import kdevelop.metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class AppCtr {

    public static void main(String[] args) {

//        //Principe d'injection des dependances
//
//        //Créer une instance de la couche DAO
//        IDao dao = new DaoImpl();
//
//        // Créer une instance de la couche metier
//        MetierImpl metier = new MetierImpl();
//
//        //injecter la couche de DAO dans la couche metier
//        metier.setDao(dao);
//
//        System.out.println("La temperature obtenue est : " + metier.calcul_temperature());

        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.next();
            String metierClassName = scanner.next();

            //Charger la Class Dao
            Class classDao = Class.forName(daoClassName);
            // instancier l'objet Dao
            IDao dao = (IDao) classDao.newInstance();
            System.out.println(dao.getTemperature());

            //Charger la class Metier en mémoire
            Class classMetier = Class.forName(metierClassName);

            //Instancier l'objet metier de la class metier
            IMetier metier = (IMetier) classMetier.newInstance();

            //Injecter la DAO dans Metier
            Method method = classMetier.getMethod("setDao", new Class []{IDao.class});
            //invoquer la methode setDao
            method.invoke(metier, new Object[]{dao});//   ==  metier.setDao(dao)

            System.out.println(metier.calcul_temperature());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
