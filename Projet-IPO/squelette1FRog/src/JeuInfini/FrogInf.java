package JeuInfini;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;
import graphicalElements.Element;

import java.awt.*;


public class FrogInf implements IFrog {

    private Game game;
    private Case c;
    private Direction d;


    public FrogInf(Game game) {
        this.game = game;
        this.c = new Case(game.width/2,0);
        this.d = Direction.up;
    }

    @Override
    public Case getPosition() { return this.c; }

    @Override
    public Direction getDirection() {
        return this.d;
    }

    @Override
    public void move(Direction key) {
        if( key == Direction.up) {
            this.c = new Case(c.absc, c.ord+1);
            this.game.hauteur = this.game.hauteur+1;
            if(this.game.hauteur >= this.game.score){
                this.game.score = this.game.hauteur;
            }
            System.out.println( "y= "+ game.hauteur +" x= " + this.c.absc+ " score= " + game.score );
            game.height = game.height+1;
        }else if( key == Direction.down && c.ord > 0) {
            this.c = new Case(c.absc, c.ord - 1);
            this.game.hauteur = this.game.hauteur-1;
            game.height = game.height-1;
            System.out.println( "y= "+ game.hauteur +" x= " + this.c.absc+ " score= " + game.score );
        }else if( key == Direction.right && c.absc < 25 && c.absc > -1) {
            this.c = new Case(c.absc + 1, c.ord);
            System.out.println( "y= "+ game.hauteur +" x= " + this.c.absc+ " score= " + game.score );
        }else if( key == Direction.left && c.absc < 26 && c.absc > 0) {
            this.c = new Case(c.absc - 1, c.ord);
            System.out.println( "y= "+ game.hauteur +" x= " + this.c.absc+ " score= " + game.score );


        }

    }


}