package comparatorex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorDemo {
	
	public static void main(String[] args) {
		ComparatorPojo obj1 = new ComparatorPojo(6,"name5");
		ComparatorPojo obj5 = new ComparatorPojo(1,"name1");
		ComparatorPojo obj2 = new ComparatorPojo(3,"name3");
		ComparatorPojo obj3 = new ComparatorPojo(2, "name2");
		ComparatorPojo obj4 = new ComparatorPojo(4,"name3");
		List<ComparatorPojo> list = new ArrayList<ComparatorPojo>();
		list.add(obj1);
		list.add(obj5);
		list.add(obj2);
		list.add(obj3);
		list.add(obj4);
		
		list.forEach(obj->System.out.println(obj.getNumber()+ "  "+obj.getName()));
		
		Collections.sort(list, (ob1,ob2) -> ob1.getName().compareTo(ob2.getName()));
		
		System.out.println("after sorting");
		
		list.forEach(obj->System.out.println(obj.getNumber()+"  "+obj.getName()));
	}

}
