package egzaminas_atsiskaitymai;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class KlientaiController {
	
	@Autowired
	private KlientaiRepository klientai_repository;	

	
	@RequestMapping(path="/klientai", method={ RequestMethod.GET, RequestMethod.POST })
    public String miestai(@RequestParam(name="id", required=false, defaultValue="0") Integer id 
			, @RequestParam(name="pav", required=false, defaultValue="") String pav
			, @RequestParam(name="flag_fizinis", required=false, defaultValue="0") String flag_fizinis	
			, @RequestParam(name="saugoti", required=false, defaultValue="nesaugoti") String saugoti			
			, Model model) {
		//, @RequestParam(name="kid", required=false, defaultValue="nesaugoti") Integer id 
		String res = "Neatlikta";
		
		Klientai klientas = new Klientai();
		
		if ( saugoti.equals( "saugoti" ) ) {
		
			if (id > 0) {
				
				Optional <Klientai> found = klientai_repository.findById( id );
			
				// variantas trynimuiui
				// uzsakymaiRepository.deleteById(id);
			
				if ( found.isPresent() ) {
				
				   klientas = found.get();
				   klientas.setId ( id );
				   
				} else {
					
					res = "Klaida įrašas galėjoi būti pašalintas";
				}
			}	
			
		    klientas.setPav( pav );
		    klientas.setFlag_fizinis( Integer.parseInt ( flag_fizinis) );

		  
		    klientai_repository.save ( klientas );
		    res = "Saugoti";
		    
			return "redirect:/saskaitos?kid=" + klientas.getId();		    
		    
		}
        model.addAttribute("lst_menu", Meniu.values() ); 
    	model.addAttribute("klientai", klientai_repository.findAll() );
    	model.addAttribute("res", res );
    	
    	
    	return "klientai";
	
	}	

}
