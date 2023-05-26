package validation;

import models.Profissao;

public class SalarioValidation {

	public static boolean validador( Profissao profissao, Float salario ) {
		if( profissao.getSalarioBase() < salario ) {
			return false;
		}
		return true;
	}
}
