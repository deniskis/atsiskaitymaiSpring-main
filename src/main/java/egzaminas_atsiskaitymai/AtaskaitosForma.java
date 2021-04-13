package egzaminas_atsiskaitymai;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.persistence.*;

public class AtaskaitosForma {
	
	  protected Session em;	
		
	  public AtaskaitosForma(  Session em  ) {
		  
		    this.em = em;
	  }	
	  
	  public List<Ataskaita> saskaituApmokejimai( String pasirinkti_klientai, double suma_skolos_fiziniams, double suma_skolos_juridiniams ) {

		 String where_part = "";
	
			switch  ( pasirinkti_klientai ) {
			
			case "fiziniai": 	
				where_part += " AND klientai.`flag_fizinis`";	
			break;	
			case "juridiniai":	
				where_part += " AND NOT klientai.`flag_fizinis`";	
			break;
	
		}
			String qw_saskaitu_apmokejimai =
				"SELECT \r\n"
				+ " `klientai`.*\r\n"
				+ ", COUNT(`klientai`.`id`) AS `kiek_saskaitu`\r\n"
				+ ", IFNULL( SUM(DISTINCT `saskaitos`.`suma`),0) AS `Saskaitu_suma`\r\n"
				+ ", SUM(IFNULL(`apmokejimai`.`suma`,0)) AS `Apmoketa_suma`\r\n"
				+ ", IFNULL(SUM(DISTINCT `saskaitos`.`suma`),0)- IFNULL(SUM(DISTINCT `apmokejimai`.`suma`),0) AS `Neapmoketas_likutis` \r\n"
				+ "FROM \r\n"
				+ "	`klientai` \r\n"
				+ "LEFT JOIN `saskaitos` ON ( \r\n"
				+ "    	`klientai`.`id`=`saskaitos`.`klientai_id`\r\n"
				+ "    )\r\n"
				+ "LEFT JOIN `apmokejimai` ON (\r\n"
				+ "    	`apmokejimai`.`saskaitos_id`=`saskaitos`.`id`\r\n"
				+ "   )\r\n"
				+ "WHERE 1\r\n"
		  		+ " "+ where_part +"\r\n"
				+ "GROUP BY `klientai`.`id`\r\n"
		  		+ "HAVING\r\n"
		  		+ "`Saskaitu_suma`> IF(`klientai`.`flag_fizinis`," + suma_skolos_fiziniams+ "," +suma_skolos_juridiniams +")\r\n"
				+	";";

		  	System.out.println ( qw_saskaitu_apmokejimai );
		    Query query = em.createNativeQuery ( qw_saskaitu_apmokejimai );
		    return (List<Ataskaita>) query.getResultList();
	  }	  	  

}