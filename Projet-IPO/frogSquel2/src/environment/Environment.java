package environment;

import java.util.ArrayList;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {


    private Game game;
    private ArrayList<Lane> lignes = new ArrayList<>();


    public Environment(Game game) {
        this.game = game;
        for (int i = 1; i < game.height - 1; i++) {
            lignes.add(new Lane(game, i, game.randomGen.nextBoolean()));

            if (game.absFrog() == 1) {           //*****************************************************//
                lignes.add(new Lane(game, i+1, game.randomGen.nextBoolean()));
                //ligne.remove(0);
            }                  //***************************************************************************//
        }
    }

    @Override
    public boolean isSafe(Case c) {
        for (Lane l : lignes) {
            if (!l.isSafe(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == game.height-1;
    }

    @Override
    public void update() {
        for(Lane l: lignes) {
            l.update();
        }
    }
    //TODO



}