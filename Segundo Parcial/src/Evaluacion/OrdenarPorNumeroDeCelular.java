package Evaluacion;

import java.util.Comparator;

public class OrdenarPorNumeroDeCelular implements Comparator <Persona>{

	@Override
	public int compare(Persona persona1, Persona persona2) {
		return persona1.getNumeroDeMovil() - persona2.getNumeroDeMovil();
	}

}
