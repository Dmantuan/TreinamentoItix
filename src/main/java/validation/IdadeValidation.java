package validation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class IdadeValidation {

	public static boolean validador( LocalDate data ) {

		long diferencaEmMes = ChronoUnit.MONTHS.between( data, LocalDate.now() );

		if( diferencaEmMes < 18 * 12 ) {
			return false;
		}
		return true;
	}
}
