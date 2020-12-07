package gameCommons;

import java.awt.Color;
import java.util.Random;

import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;
import gameCommons.IEnvironment;
import util.Case;

public class Game {

	public final Random randomGen = new Random();

	// Caracteristique de la partie
	public final int width;
	public  int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;
	public int score = 0;
	public int hauteur = 0;
	public final long timerini = System.currentTimeMillis();
	public boolean fini = false;

	// Lien aux objets utilis�s
	private IEnvironment environment;
	private IFrog frog;
	private IFrog2 frog2;
	private IFroggerGraphics graphic;

	/**
	 *
	 * @param graphic
	 *            l'interface graphique
	 * @param width
	 *            largeur en cases
	 * @param height
	 *            hauteur en cases
	 * @param minSpeedInTimerLoop
	 *            Vitesse minimale, en nombre de tour de timer avant d�placement
	 * @param defaultDensity
	 *            densite de voiture utilisee par defaut pour les routes
	 */
	public Game(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
		super();
		this.graphic = graphic;
		this.width = width;
		this.height = height;
		this.minSpeedInTimerLoops = minSpeedInTimerLoop;
		this.defaultDensity = defaultDensity;
	}

	/**
	 * Lie l'objet frog � la partie
	 *
	 * @param frog
	 */
	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	public void setFrog2(IFrog2 frog2) {
		this.frog2 = frog2;
	}

	/**
	 * Lie l'objet environment a la partie
	 *
	 * @param environment
	 */
	public void setEnvironment(IEnvironment environment) {
		this.environment = environment;
	}

	/**
	 *
	 * @return l'interface graphique
	 */
	public IFroggerGraphics getGraphic() {
		return graphic;
	}

	/**
	 * Teste si la partie est perdue et lance un �cran de fin appropri� si tel
	 * est le cas
	 *
	 * @return true si le partie est perdue
	 */
	public boolean testLose() {


		if (!environment.isSafe(frog.getPosition())) {

			if (fini == false ) {
				final long timermilli = System.currentTimeMillis() - timerini;


				final long timerS = timermilli / 1000;
				String TimeStr = Long.toString(timerS);
				graphic.endGameScreen("Joueur 2 gagné !" + "  " +
						"Durée = " + TimeStr+ "s");
				fini = true;

			}

		}
		if (!environment.isSafe(frog2.getPosition2())) {

			if (fini == false ) {
				final long timermilli = System.currentTimeMillis() - timerini;


				final long timerS = timermilli / 1000;
				String TimeStr = Long.toString(timerS);
				graphic.endGameScreen("Joueur 1 a gagné !" + "  " +
						"Durée = " + TimeStr+ "s");
				fini = true;

			}

		}
		return false;
	}

	/**
	 * Teste si la partie est gagnee et lance un �cran de fin appropri� si tel
	 * est le cas
	 *
	 * @return true si la partie est gagn�e
	 */
	public boolean testWin() {
		if (environment.isWinningPosition(frog.getPosition())) {
			if (!fini ) {
				final long timermilli = System.currentTimeMillis() - timerini;


				final long timerS = timermilli / 1000;
				String TimeStr = Long.toString(timerS);
				graphic.endGameScreen("Joueur 1 a gagné !" + "  " +
						"Durée = " + TimeStr+ "s" );
				fini = true;

			}

			return true;

		}
		if (environment.isWinningPosition(frog2.getPosition2())) {
			if (!fini ) {
				final long timermilli = System.currentTimeMillis() - timerini;


				final long timerS = timermilli / 1000;
				String TimeStr = Long.toString(timerS);
				graphic.endGameScreen("Joueur 2 a gagné !" + "  " +
						"Durée = " + TimeStr + "s" );
				fini = true;

			}

			return true;

		}
		return false;
	}

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */
	public void update() {
		graphic.clear();
		environment.update();
		this.graphic.add(new Element(frog.getPosition().absc, frog.getPosition().ord, Color.GREEN));
		this.graphic.add(new Element(frog2.getPosition2().absc, frog2.getPosition2().ord, Color.RED));
		testLose();
		testWin();
		System.out.println("Y = " + frog.getPosition().ord);
	}

	public int absFrog() {
		return frog.getPosition().absc;
	}
}

