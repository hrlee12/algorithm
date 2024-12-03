package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Comparator {
	public static void main(String args[]) {
		Human[] people = new Human[3];
		people[0] = new Human(2, "hyori");
		people[1] = new Human(3, "nari");
		people[2] = new Human(1, "hyodong");

		Arrays.sort(people, (o1, o2) -> {return o1.age - o2.age;});

		for (int idx = 0; idx < people.length; idx++) {
			System.out.println(people[idx].age);
		}

		List<Human> peopleList = new ArrayList<>();
		peopleList.add(new Human(2, "hyori"));
		peopleList.add(new Human(3, "nari"));
		peopleList.add(new Human(1, "hyodong"));

		Collections.sort(peopleList, (o1, o2) -> {return o2.age - o1.age;});

		for (int idx = 0; idx < peopleList.size(); idx++) {
			System.out.println(peopleList.get(idx).age);
		}
	}


}

	class Human {
		int age;
		String name;

		public Human(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

