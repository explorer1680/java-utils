package personal.java8.stream;

import java.util.ArrayList;
import java.util.List;

public class CountPopulation {

	static class Country {
		private String countryName;
		private String continent;
		private int population;
		

		public Country(String countryName, String continent, int population) {
			super();
			this.countryName = countryName;
			this.continent = continent;
			this.population = population;
		}

		public String getCountryName() {
			return countryName;
		}

		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}

		public String getContinent() {
			return continent;
		}

		public void setContinent(String continent) {
			this.continent = continent;
		}

		public int getPopulation() {
			return population;
		}

		public void setPopulation(int population) {
			this.population = population;
		}

		@Override
		public String toString() {
			return "Country [countryName=" + countryName + ", continent=" + continent + ", population=" + population
					+ "]";
		}
	}

	public static void main(String[] args){
		List<Country> countryList = new ArrayList<>();
		Country a1 = new Country("A1", "A", 123);
		Country a2 = new Country("A2", "A", 23);
		Country a3 = new Country("A3", "A", 231);
		
		Country b1 = new Country("B1", "B", 123);
		Country b2 = new Country("B2", "B", 23);
		Country b3 = new Country("B3", "B", 231);
		
		countryList.add(b3);
		countryList.add(b2);
		countryList.add(b1);
		countryList.add(a1);
		countryList.add(a2);
		countryList.add(a3);
		
//		int count = countryList.stream().filter(p -> p.getContinent().equals("A")).mapToInt(c -> c.getPopulation()).sum();
		int count = countryList.stream().filter(p -> p.getContinent().equals("A")).reduce(100, (x, y) -> x + y.getPopulation(), (x, y) -> x + y);
		
		
		System.out.println(count);
	}
}
