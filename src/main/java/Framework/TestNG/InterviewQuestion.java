package Framework.TestNG;

public class InterviewQuestion {
	
	/*
    Write a method which prints out the numbers from start to end, BUT
    for numbers which are a multiple of 3, print FIN instead of the number, AND
    for numbers which are a multiple of 5, print RA instead of the number. FINALLY,
    for numbers which are a multiple of both fin AND ra, print FINRA instead of the number
    Example Output:
    1
    2
    FIN
    4
    RA
    FIN
    7
    8
    FIN
    RA
    11
    FIN
    13
    14
    FINRA
    16
    …
    */
/*	public static void main(String[] args) {
		
	for(int i = 1; i<50; i++) {
		if(i%3 == 0) {
			System.out.println("FINRA");
		}else if (i%5 == 0) {
			System.out.println("FIN");
		}else if(i%3 == 0 && i%5 == 0) {
			System.out.println("RA");
		}else
			System.out.println(i);
     	}*/
	public static void printNums(int start, int end) {
		for(int i = start; i<end; i++) {
			if(i%3 == 0) {
				System.out.println("FINRA");
			}else if (i%5 == 0) {
				System.out.println("FIN");
			}else if(i%3 == 0 && i%5 == 0) {
				System.out.println("RA");
			}else
				System.out.println(i);
	     	}
	}
	public static void main(String[] args) {
		printNums(1, 50);
	
	
	}

}
