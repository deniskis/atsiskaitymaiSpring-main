package egzaminas_atsiskaitymai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Controller
public class AtaskaitaController {
	
	@Autowired 
	EntityManagerFactory factory;	
	
	// @Bean
	public SessionFactory sessionFactory() {

		
	        if (factory.unwrap(SessionFactory.class) == null) {
	            throw new NullPointerException("factory is not a hibernate factory");
	        }
	        return factory.unwrap(SessionFactory.class);
	}	

	
	@RequestMapping(path="/ataskaita", method={ RequestMethod.GET, RequestMethod.POST })
    public String Apmokejimai( @RequestParam(name="neapmoketa_saskaita", required=false, defaultValue="0") Integer neapmoketa_saskaita 
			, @RequestParam(name="ieskoti", required=false, defaultValue="neieskoti") String ieskoti
			, @RequestParam(name="suma_skolos_fiziniams", required=false, defaultValue="300") String suma_skolos_fiziniams	
			, @RequestParam(name="suma_skolos_juridiniams", required=false, defaultValue="1000") String suma_skolos_juridiniams	
			, @RequestParam(name="fiziniai", required=false, defaultValue="0") Integer fiziniai
			, @RequestParam(name="juridiniai", required=false, defaultValue="0") Integer juridiniai	
			, @RequestParam(name="visi", required=false, defaultValue="0") Integer visi	
			, Model model) {
		
		String rez = "Neatlikta";
		
		String klientai = "visi";
		
		if (visi == 0) {
			
			if ((fiziniai != 0) && (juridiniai == 0)) {
				klientai = "fiziniai";
			}
			if ((fiziniai == 0) && (juridiniai != 0)) {
				klientai = "juridiniai";
			}
		}
		
		/*Apmokejimai apmokejimas = new Apmokejimai();
		
		if ( neapmoketa_saskaita == null ) {
			
			neapmoketa_saskaita = 100000;
			

		    rez = "Saugoti";
		    
		}*/
		
		Session session = this.sessionFactory().openSession();
		
		AtaskaitosForma bandymas =  new AtaskaitosForma( session );
        model.addAttribute("lst_menu", Meniu.values() ); 
        model.addAttribute("lst_paslaugos_kaina", bandymas.saskaituApmokejimai( klientai, Double.parseDouble(suma_skolos_fiziniams), Double.parseDouble(suma_skolos_juridiniams)) ); 		
		return "apmokejimu_ataskaita";
	}	
}