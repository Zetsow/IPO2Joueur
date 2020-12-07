package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;





public class Frog implements IFrog {

	private Game game;
	private Case c;
	private Direction d;

	public Frog(Game game) {
		this.game = game;
		this.c = new Case(game.width/4,0);
		this.d = Direction.up;
	}

	@Override
	public Case getPosition() {
		return this.c;
	}

	@Override
	public Direction getDirection() {
		return this.d;
	}

	@Override
	public void move(Direction key) {
		if( key == Direction.up) {
			this.c = new Case(c.absc, c.ord+1);
		}else if( key == Direction.down && c.ord > 0) {
			this.c = new Case(c.absc, c.ord - 1);
		}else if( key == Direction.right && c.absc < 25 && c.absc > -1) {
			this.c = new Case(c.absc + 1, c.ord);
		}else if( key == Direction.left && c.absc < 26 && c.absc > 0) {
			this.c = new Case(c.absc - 1, c.ord);
		}
	}

}