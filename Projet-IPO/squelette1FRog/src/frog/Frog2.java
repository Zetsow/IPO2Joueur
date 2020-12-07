package frog;

import gameCommons.Game;
import gameCommons.IFrog2;
import util.Case;
import util.Direction;


public class Frog2 implements IFrog2 {

	private Game game;
	private Case c;
	private Direction d;

	public Frog2(Game game) {
		this.game = game;
		this.c = new Case((3*game.width)/4,0);
		this.d = Direction.up;
	}

	@Override
	public Case getPosition2() {
		return this.c;
	}

	@Override
	public Direction getDirection2() {
		return this.d;
	}

	@Override
	public void move2(Direction key) {
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