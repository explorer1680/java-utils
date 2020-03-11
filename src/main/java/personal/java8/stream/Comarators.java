package personal.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Comarators {

	public static void main(String[] args) {
		Country a = new Country(100L);
		Country b = new Country(100L);
		Country c = new Country(300L);

		List<Country> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		Country min = list.stream()
//				.min((i, j) -> i.getCcity().getPopulation().compareTo(j.getCcity().getPopulation())) //this working
//				.min(Comparator.comparing(i -> i.getCcity().getPopulation()))//this is also working
				.min(Comparator.comparing(i -> i.getCcity().getPopulation(), Comparator.reverseOrder()))//this is also working
				.get();
		// this is not correct
		// .min(Comparator.comparing(Country::CapitalCity::getPopulation)).get();

//		System.out.println(min);
		
		List<Country> middleList = list.stream().sorted(Comparator.comparing(i -> i.getCcity().getPopulation())).collect(Collectors.toList());
		
		Country minPopulationCountry = middleList.get(0);
		
			middleList.stream()
				.filter(p -> p.getCcity().getPopulation() <= minPopulationCountry.getCcity().getPopulation())
				.collect(Collectors.toList()).forEach(System.out::println);
		
	
	}

}

class Country {
	// private String name;
	private CapitalCity Ccity;

	Country(Long population) {
		// this.name = name;
		this.Ccity = new CapitalCity(population);
	}

	public CapitalCity getCcity() {
		return Ccity;
	}

	@Override
	public String toString() {
		return "Country [Ccity=" + Ccity + "]";
	}

}

class CapitalCity {

	private Long population;

	CapitalCity(Long population) {
		this.population = population;
	}

	public Long getPopulation() {
		return population;
	}

	@Override
	public String toString() {
		return "CapitalCity [population=" + population + "]";
	}

}