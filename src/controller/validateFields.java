package controller;

public class validateFields implements parametrizable{
	public static boolean validateNames(String names) {
		return names.matches(ERNames);
	}
	public static boolean validateAge(int age) {
		return String.valueOf(age).matches(ERAge);
	}
	public static boolean validateDNI(long dni) {
		return String.valueOf(dni).matches(ERDNI);
	}
}
