package functional_interface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import model.Person;
import model.PersonRepository;

public class F05_BiPredicateDemo {
	public static void main(String[] args) {
		
		//BiPredicate accepts two params
		//its methods are test,and,or
		
		BiPredicate<String,Integer> genderAndHeightPredicate = (gender,height) -> gender.equals("male") && height >= 100 ;
		BiConsumer<String, List<String>> nameHobbiesConsumer = (personName, personHobbies) -> System.out.println(personName + "-" + personHobbies);
		Consumer<Person> personConsumer = (person) -> {
			if (genderAndHeightPredicate.test(person.getGender(),person.getHeight())) {
				nameHobbiesConsumer.accept(person.getFirstName(), person.getHobbies());
			}
		};
		PersonRepository.getAllPesons().stream().forEach(personConsumer);
	}
}
