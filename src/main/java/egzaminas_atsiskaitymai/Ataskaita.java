package egzaminas_atsiskaitymai;

import java.lang.Boolean;
import java.lang.Integer;

public class Ataskaita {

		// id
		private String pav;
		private int flag_fizinis;
		private int kiek_saskaitu;
		private int neapmoketa_saskaita;
		private int apmoketa_saskaita;
		private int neapmoketas_likutis;
		
		public Ataskaita() {

		}		
		
		public Ataskaita(String pav, int flag_fizinis, int kiek_saskaitu, int neapmoketa_saskaita, int apmoketa_saskaita, int neapmoketas_likutis ) {
			super();
			this.pav = pav;
			this.flag_fizinis = flag_fizinis;
			this.kiek_saskaitu = kiek_saskaitu;
			this.neapmoketa_saskaita = neapmoketa_saskaita;
			this.apmoketa_saskaita = apmoketa_saskaita;
			this.neapmoketas_likutis = apmoketa_saskaita;
		}

		public int getNeapmoketas_likutis() {
			return neapmoketas_likutis;
		}

		public void setNeapmoketas_likutis(int neapmoketas_likutis) {
			this.neapmoketas_likutis = neapmoketas_likutis;
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

		public int getKiek_saskaitu() {
			return kiek_saskaitu;
		}

		public void setKiek_saskaitu(int kiek_saskaitu) {
			this.kiek_saskaitu = kiek_saskaitu;
		}

		public int getNeapmoketa_saskaita() {
			return neapmoketa_saskaita;
		}

		public void setNeapmoketa_saskaita(int neapmoketa_saskaita) {
			this.neapmoketa_saskaita = neapmoketa_saskaita;
		}

		public int getApmoketa_saskaita() {
			return apmoketa_saskaita;
		}

		public void setApmoketa_saskaita(int apmoketa_saskaita) {
			this.apmoketa_saskaita = apmoketa_saskaita;
		}

		
}