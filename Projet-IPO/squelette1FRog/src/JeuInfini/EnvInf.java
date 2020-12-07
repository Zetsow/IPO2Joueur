package JeuInfini;

import java.util.ArrayList;
import java.util.Iterator;

import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class EnvInf implements IEnvironment {


    private Game game;
    private ArrayList<LaneInf> lignes = new ArrayList<>();


    public EnvInf(Game game) {
        this.game = game;
        for (int i = 1; i < game.height - 1; i++) {
            lignes.add(new LaneInf(game, i, game.randomGen.nextBoolean()));

            if (game.absFrog() == 1) {           //*****************************************************//
                lignes.add(new LaneInf(game, i + 1, game.randomGen.nextBoolean()));
                //ligne.remove(0);
            }                  //***************************************************************************//
        }
    }

    @Override
    public boolean isSafe(Case c) {
        for (LaneInf l : lignes) {
            if (!l.isSafe(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == game.height - 1;
    }

    @Override
    public void update() {
        Iterator var2 = this.lignes.iterator();

        while(var2.hasNext()) {
            LaneInf lane = (LaneInf)var2.next();
            lane.update();
        }
    }
}
//TODO



