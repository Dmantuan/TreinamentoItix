package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatadorLocalDate {

	private static DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern( "dd/MM/yyyy" );

	public static LocalDate formatarData( String data ) {
		return LocalDate.parse( data, FormatadorLocalDate.dateFormater );
	}
}
