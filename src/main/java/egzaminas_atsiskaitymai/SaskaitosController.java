package egzaminas_atsiskaitymai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SaskaitosController {
	
	@Autowired
	private SaskaitosRepository saskaitos_repository;	
	
	@Autowired
	private ApmokejimaiRepository apmokejimai_repository;	
	
	@RequestMapping(path="/saskaitos", method={ RequestMethod.GET, RequestMethod.POST })
    public String miestai(@RequestParam(name="kid", required=false, defaultValue="0") Integer kid 
			, @RequestParam(name="data", required=false, defaultValue="") String data
			, @RequestParam(name="suma", required=false, defaultValue="0") String suma	
			, @RequestParam(name="saugoti", required=false, defaultValue="nesaugoti") String saugoti			
			, @RequestParam(name="saskaitos_id", required=false, defaultValue="0") String saskaitos_id			
			, @RequestParam(name="pay", required=false, defaultValue="neapmoketi") String pay			
			, Model model) {
		
		String res = "Neatlikta";

		
		Saskaitos saskaita = new Saskaitos();
		
		if ( saugoti.equals( "saugoti" ) ) {
		
			saskaita.setData( data );
			saskaita.setSuma( Double.parseDouble ( suma ) );
			saskaita.setKlientaiId ( kid );
		    saskaitos_repository.save ( saskaita );
	 		    res = "Saugoti";
		      
		}
		
		Apmokejimai apmokejimas = new Apmokejimai();		
		
		if ( pay.equals( "apmoketi" ) ) {
			
		    apmokejimas.setData( data );
		    apmokejimas.setSuma( Double.parseDouble ( suma ) );
		    apmokejimas.setSaskaitos_id( Integer.parseInt ( saskaitos_id ) );
		    
		    System.out.println ( apmokejimas.getData() + " " + apmokejimas.getSuma() + " " +  apmokejimas.getSaskaitos_id() );

		    apmokejimai_repository.save ( apmokejimas );
		    res = "Saugoti";  
		}		
		
		model.addAttribute("lst_menu", Meniu.values() );
    	model.addAttribute("saskaitos", saskaitos_repository.findByKlientaiId( kid ) );
    	model.addAttribute("res", res );
    	
    	
    	return "saskaitos";
	
	}	

}
