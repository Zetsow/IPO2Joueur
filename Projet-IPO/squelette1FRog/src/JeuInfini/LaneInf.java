package JeuInfini;

import java.util.ArrayList;
import java.util.Iterator;


import environment.Car;
import gameCommons.IFrog;
import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Direction;


public class LaneInf {
    private Game game;
    private int ord;
    private int speed;
    public ArrayList<CarInf> cars = new ArrayList<>();
    private boolean leftToRight;
    private double density;
    private int t;
    private IFrog frog;
    private ICarInf carInf;



    // TODO : Constructeur(s)
    public LaneInf(Game game, int ord, boolean leftToRight) {
        this.game = game;
        this.ord = ord;
        this.leftToRight = leftToRight;
        this.speed = game.minSpeedInTimerLoops;
        this.density = game.defaultDensity;
    }

    public void update() {
        t++;
        if (t < speed) {
            for (CarInf carInf : cars) {
                carInf.mooveCar();



            }
            mayAddCar();
            return;
        }

        for (CarInf car : cars) {
            car.addGraph();
            //car.mooveCar();
        }
        mayAddCar();
        t = 0;
    }

    // TODO

    // Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
    // d'horloge" �gal � leur vitesse
    // Notez que cette m�thode est appel�e � chaque tic d'horloge

    // Les voitures doivent etre ajoutes a l interface graphique meme quand
    // elle ne bougent pas

    // A chaque tic d'horloge, une voiture peut �tre ajout�e


    public boolean isSafe(Case c) {
        for (CarInf car : cars) {
            if (car.getPosition().absc == c.absc && car.getPosition().ord == c.ord) {
                return false;
            }
            for (int j = 1; j < car.getLength(); j++) {
                int b = car.getPosition().absc + j;
                int d = car.getPosition().ord;
                Case a = new Case(b, d);
                if (a.absc == c.absc && a.ord == c.ord) {
                    return false;
                }
            }
        }
        return true;
    }


    public ArrayList<CarInf> getAbsc(int a) {
        return this.cars;
    }

    // TODO : ajout de methodes

    /*
     * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase()
     */

    /**
     * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
     * densit�, si la premi�re case de la voie est vide
     */
    private void mayAddCar() {
        if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
            if (game.randomGen.nextDouble() < density) {
                cars.add(new CarInf(game, getBeforeFirstCase(), leftToRight));
            }
        }
    }

    private Case getFirstCase() {
        if (leftToRight) {
            return new Case(0, ord);
        } else
            return new Case(game.width - 1, ord);
    }

    private Case getBeforeFirstCase() {
        if(game.height % 2 == 0) {

            if (leftToRight) {
                return new Case(-1, game.height - 19 + 2 * game.randomGen.nextInt(game.height + 10));
            } else
                return new Case(game.width, game.height - 18 + 2 * game.randomGen.nextInt(game.height + 10));
        }
        else
        if (leftToRight) {
            return new Case(-1, game.height - 18 + 2 * game.randomGen.nextInt(game.height + 10));
        } else
            return new Case(game.width, game.height - 19 + 2 * game.randomGen.nextInt(game.height + 10));
    }




}





