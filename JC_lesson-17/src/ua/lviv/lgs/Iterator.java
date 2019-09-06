package ua.lviv.lgs;

public interface Iterator {
	public boolean hasNext();

	public Number next();
}

class Collection {
	private static Number[] arr;

	Collection(Number[] arr) {
		Collection.arr = arr;
	}

	public class Forward implements Iterator {

		private int count = 0;

		@Override
		public boolean hasNext() {
			return count < arr.length;
		}

		@Override
		public Number next() {
			return arr[count++];
		}
	}

	public Forward createForward() {
		return new Forward();
	}

	public class Backward implements Iterator {

		public int count = arr.length - 1;

		@Override
		public boolean hasNext() {
			return count >= 0;
		}

		@Override
		public Number next() {
			return arr[count--];
		}
	}

	public Backward createBackward() {
		return new Backward();
	}

	public Iterator createAnonymous() {
		return new Iterator() {

			public int count = arr.length - 1;

			@Override
			public Number next() {
				return arr[count--];
			}

			@Override
			public boolean hasNext() {
				return count >= 0;
			}
		};
	}

	public Iterator createLocal() {
		class localIterator implements Iterator {

			private int count = 0;

			@Override
			public boolean hasNext() {
				return count < arr.length;
			}

			@Override
			public Number next() {
				return arr[count++];
			}
		}
		return new localIterator();
	}

	private static class staticIterator implements Iterator {

		private int count = 0;

		@Override
		public boolean hasNext() {
			return count < arr.length;
		}

		@Override
		public Number next() {
			return arr[count++];
		}
	}

	public static staticIterator createStaticIterator() {
		return new staticIterator();
	}

}
