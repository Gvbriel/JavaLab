package lab4;

import java.util.Random;

public class Okrag {

	Random r = new Random();
	
	public Okrag(int numer) {
		this.x = (int)(Math.random() * (95 - 5 + 1) + 5);
		this.y = (int)(Math.random() * (95 - 5 + 1) + 5);
		this.promien = (float)(Math.random() * (5 - 1 + 1) + 1);
		this.numer = numer;
	}
	
	int x,y, numer;
	float promien;
	
}
