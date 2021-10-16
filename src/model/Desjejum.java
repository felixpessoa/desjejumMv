package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Desjejum {

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESJEJUM")
		@SequenceGenerator(name="DESJEJUM", sequenceName="S_ID_LEVAR", allocationSize = 1, initialValue = 100)
		private int id_levar;
		
		private String levar;

		public Desjejum() {
			super();
		}

		public Desjejum(int id_levar, String levar) {
			super();
			this.id_levar = id_levar;
			this.levar = levar;
		}

		public int getId_levar() {
			return id_levar;
		}

		public void setId_levar(int id_levar) {
			this.id_levar = id_levar;
		}

		public String getLevar() {
			return levar;
		}

		public void setLevar(String levar) {
			this.levar = levar;
		}

		@Override
		public String toString() {
			return "Desjejum [id_levar=" + id_levar + ", levar=" + levar + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id_levar;
			result = prime * result + ((levar == null) ? 0 : levar.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Desjejum other = (Desjejum) obj;
			if (id_levar != other.id_levar)
				return false;
			if (levar == null) {
				if (other.levar != null)
					return false;
			} else if (!levar.equals(other.levar))
				return false;
			return true;
		}
		
		
		
		
}
