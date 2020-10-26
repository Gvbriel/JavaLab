package lab3;

import java.util.Scanner;

public class SzyfrCezara {

	char tabZnakow[], szyfr[], odszyfrowany[];
	static Scanner scanner = new Scanner(System.in);

	//Zaszyfruj tekst
	public void Szyfrowanie(String tekst, int przesuniecie) {
		char szyfr[] = new char[tekst.length()];
		tabZnakow = tekst.toCharArray();
		int temp = 0;

		for (int x = 0; x < tabZnakow.length; x++) {
			temp = (char) tabZnakow[x];
			if (temp >= 97 && temp <= 122) {
				szyfr[x] = (char) (((temp + przesuniecie - 97) % 26) + 97);
			} else if (temp >= 65 && temp <= 90) {
				szyfr[x] = (char) (((temp + przesuniecie - 65) % 26) + 65);
			} else {
				szyfr[x] = tabZnakow[x];
			}

		}

		System.out.println("Zaszyfrowany:");
		for (char x : szyfr) {
			System.out.print(x);
		}
		System.out.println();
	}

	//Odszyfruj Szyfr Cezara
	public void Odszyfrowanie(String tekst, int przesuniecie) {
		char odszyfrowany[] = new char[tekst.length()];
		tabZnakow = tekst.toCharArray();
		int temp = 0;

		for (int x = 0; x < tabZnakow.length; x++) {
			temp = (char) tabZnakow[x];
			if (temp >= 97 && temp <= 122) {
				for (int i = 0; i < przesuniecie; i++) {
					temp--;
					if (temp < 97)
						temp = 122;
				}
				odszyfrowany[x] = (char) (temp);
			} else if (temp >= 65 && temp <= 90) {
				for (int i = 0; i < przesuniecie; i++) {
					temp--;
					if (temp < 65)
						temp = 90;
				}
				odszyfrowany[x] = (char) (temp);
			} else {
				odszyfrowany[x] = tabZnakow[x];
			}

		}

		System.out.println("Odszyfrowany: ");
		for (char x : odszyfrowany) {
			System.out.print(x);
		}

	}

	//Sprawdz czy tekst jest palindromem
	public void Palindrom(String tekst) {
		char palindromx[] = new char[tekst.length()];
		int dlugosc = tekst.length();
		boolean isPalindrom = true;
		palindromx = tekst.toCharArray();

		for (int i = 0; i < dlugosc; i++) {
			if (palindromx[i] == palindromx[dlugosc - 1 - i]) {
				isPalindrom = true;
			} else {
				isPalindrom = false;
			}
		}

		if (isPalindrom) {
			System.out.println(tekst + " to palindrom.");
		} else {
			System.out.println(tekst + " nie jest palindromem.");
		}
	}

	//Znalezienie nadluzszego ciagu zer w rozwinieciu binarnym cyfry, ciag zer musi byc miedzy cyfra 1
	public void Binarka(int podana) {
		
		int max = 0;
		char helpArray[];

		System.out.println(Integer.toBinaryString(podana));

		String temp = Integer.toBinaryString(podana);
		String tempArr[] = Integer.toBinaryString(podana).split("1");
		helpArray = Integer.toBinaryString(podana).toCharArray();

		boolean ifZero = false;

		ifZero = helpArray[helpArray.length - 1] == '0';

		if (ifZero) {
			tempArr[tempArr.length - 1] = "";
		}

		for (int i = 0; i < tempArr.length; i++) {
			if (max < tempArr[i].length()) {
				max = tempArr[i].length();
			}
		}

		System.out.println("Najd³u¿sza sekwencja zer to : " + max);
	}

	public SzyfrCezara() {

	}

	public void main(String[] args) {
		Szyfrowanie("aaFFV.cx", 3);
	}

}
