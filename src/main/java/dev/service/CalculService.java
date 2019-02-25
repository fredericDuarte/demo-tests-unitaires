package dev.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exception.CalculException;

public class CalculService {

	private static final Logger LOG = LoggerFactory.getLogger(CalculService.class);

	public int additionner(String expression) throws CalculException {

		LOG.debug("Evaluation de l'expression" + expression);
		int somme = 0;
		String[] equation = expression.split("\\+");
		try {
			for (String equ : equation) {
				somme += Integer.parseInt(equ);
			}
		} catch (Exception e) {
			throw new CalculException("L'expression " + expression + " est invalide");
		}

		return somme;
	}
}
