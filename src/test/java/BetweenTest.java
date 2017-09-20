import com.sbg.aventura.util.between;

public class BetweenTest {
	public static void main(String[] args) {
		System.out.println(between.isBetween(-1, 0, 10));
		System.out.println(between.isBetween(0, 0, 10));
		System.out.println(between.isBetween(5, 0, 10));
		System.out.println(between.isBetween(10, 0, 10));
		System.out.println(between.isBetween(11, 0, 10));
		System.out.println(between.isBetweenWithEnds(0, 0, 10));
		System.out.println(between.isBetweenWithEnds(-1, 0, 10));
		System.out.println(between.isBetweenWithEnds(5, 0, 10));
		System.out.println(between.isBetweenWithEnds(11, 0, 10));
		System.out.println(between.isBetweenWithEnds(10, 0, 10));
	}
}
