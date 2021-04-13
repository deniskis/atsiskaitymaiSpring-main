package egzaminas_atsiskaitymai;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.io.Serializable;
import java.util.List;
import java.util.Set;



@Entity
public class Saskaitos implements Serializable {

	private static final long serialVersionUID = 6406180759404589852L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	public int id;
	
	public String data;
	
	public double suma;
	
	public int klientaiId;
	
    @OneToMany 
    @JoinColumn(name="saskaitos_id", referencedColumnName="id", insertable=false, updatable=false)      
	private List<Apmokejimai> apmokejimai;


	
	public Saskaitos() {
		super();
	}	

	public Saskaitos(int id, String data, double suma, int klientai_id) {
		super();
		this.id = id;
		this.data = data;
		this.suma = suma;
		this.klientaiId = klientai_id;
	}
	
	public List<Apmokejimai> getApmokejimai() {
		return apmokejimai;
	}
	
	public void setApmokejimai(List<Apmokejimai> apmokejimai) {
		this.apmokejimai = apmokejimai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public int getKlientaiId() {
		return klientaiId;
	}

	public void setKlientaiId(int klientai_id) {
		this.klientaiId = klientai_id;
	}
}
