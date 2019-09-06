package ua.lviv.lgs;

public class Application {

	public static void main(String[] args) {
		Number[] number = {254, 2, -5, 45, 28, 1, 25, 44, -2, 34, 45, -8};
		
		System.out.println("Output data in forward order:");
		
		Collection collection = new Collection(number);
		Iterator iterForward = collection.createForward();

		while (iterForward.hasNext()) {
			Number elemForward = iterForward.next();
			if (elemForward.intValue() % 2 != 0) {
				elemForward = 0;
			}
			System.out.println(elemForward);
		}
		
		System.out.println();
		System.out.println("Output data in backward order after one digit:");
		
		Iterator iterBackward = collection.createBackward();
		
		int i = 1;
		while (iterBackward.hasNext()) {
			Number elemBackward = iterBackward.next();
			if (i % 2 == 0) {
				System.out.println(elemBackward);
			}
			i++;
		}
		
		System.out.println();
		System.out.println("Output data from anonymous class:");
		
		Iterator iterAnonymous = collection.createAnonymous();
		
		int m = 1; 
		while (iterAnonymous.hasNext()) {
			Number elemAnonymous = iterAnonymous.next();
			if (m % 3 == 0) {
				if (elemAnonymous.intValue() % 2 != 0) {
					System.out.println(elemAnonymous);
				}
			}
			m++;
		}
		
		System.out.println();
		System.out.println("Output data from local class:");
		
		Iterator iterLocal = collection.createLocal();
		
		int n = 1;
		while (iterLocal.hasNext()) {
			Number elemLocal = iterLocal.next();
			if (n % 5 == 0) {
				if (elemLocal.intValue() % 2 == 0) {
					elemLocal = elemLocal.intValue() - 100;
					System.out.println(elemLocal);
				}
			}
			n++;
		}
		
		System.out.println();
		System.out.println("Output data from static class:");

		Iterator iterStatic = Collection.createStaticIterator();
		
		int y = 1;
		while (iterStatic.hasNext()) {
			Number elemStatic = iterStatic.next();
			if (y % 2 == 0) {
				if (elemStatic.intValue() % 2 == 0) {
					elemStatic = elemStatic.intValue() + 1;
					System.out.println(elemStatic);
				}
			}
			y++;
		}
	}

}
