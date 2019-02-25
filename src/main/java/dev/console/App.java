package dev.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exception.CalculException;
import dev.service.CalculService;
import dev.utils.*;

public class App {
	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	private Scanner scanner;
	private CalculService calculatrice;

	public App(Scanner scanner, CalculService calculatrice) {
		this.scanner = scanner;
		this.calculatrice = calculatrice;
	}

	protected void afficherTitre() {

		LOG.info("**** Application Calculatrice ****");
	}

	public void demarrer() {
		afficherTitre();

		String saisie = null;
		while (!saisie.equals("fin")) {
			LOG.info("Veuillez saisir une expression :");
			saisie = this.scanner.nextLine();
			evaluer(saisie);

		}
		LOG.info("Au revoir");

	}

	protected void evaluer(String expression) {

		try {
			int add = calculatrice.additionner(expression);
			System.out.println("****  " + add);
			LOG.debug(expression + "=" + add);
		} catch (CalculException e) {
			LOG.debug("L'expression " + expression + " est invalide.");
		}

	}

}
