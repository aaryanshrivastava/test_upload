package test;

public class t_3_rootsFinder {
	
	public static double[] find_roots(double a, double b, double c) {
		if (a == 0) {
			System.out.println("The value of a must be non-zero.");
		}

		double noOfRoots = b * b - 4 * a * c;

		if (noOfRoots < 0) {
			return new double[] {};
		}

		if (noOfRoots == 0) {
			return new double[] { -b / (2 * a) };
		}
		double root1 = (-b + Math.sqrt(noOfRoots)) / (2 * a);
		double root2 = (-b - Math.sqrt(noOfRoots)) / (2 * a);

		return new double[] { root1, root2 };
	}

	public static void main(String[] args) {
		double a = 2;
		double b = 10;
		double c = 8;

		double[] roots = find_roots(a, b, c);

		System.out.println("The roots of the equation ax^2 + bx + c = 0 are " + roots[0] + " and " + roots[1]);
	}
}
