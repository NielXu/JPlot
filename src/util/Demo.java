package util;

public class Demo {

    public static void main(String[] args) {
	// Get 10 random values that are either 1 or 0
	int[] bin = Randomizer.bin_randarray(10);
	for (int i = 0; i < bin.length; i++) {
	    System.out.println(bin[i]);
	}

	// Get 10 random relative values
	double[] arr = Randomizer.relative_rand(5.0, 2.0, 10);
	for (int i = 0; i < arr.length; i++) {
	    System.out.println(arr[i]);
	}

    }

}
