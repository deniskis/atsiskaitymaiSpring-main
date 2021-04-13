package egzaminas_atsiskaitymai;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Klientai {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	public int id;
	
	public String pav;
	
	public int flag_fizinis;
	
	public Klientai() {
		super();
	}	

	public Klientai(int id, String pav, int flag_fizinis) {
		super();
		this.id = id;
		this.pav = pav;
		this.flag_fizinis = flag_fizinis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public int getFlag_fizinis() {
		return flag_fizinis;
	}

	public void setFlag_fizinis(int flag_fizinis) {
		this.flag_fizinis = flag_fizinis;
	}
	
	

}
