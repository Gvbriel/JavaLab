package lab4;

import java.util.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static int[] MakeArr() {
		int arr[] = new int[100];

		for (int i = 0; i < 100; i++) {
			arr[i] = i;
		}
		return arr;
	}

	public static int RandomNumber() {
		double randomD = Math.random() * (20 + 20 + 1) - 20;
		int random = (int) Math.round(randomD);
		return random;
	}

	public static int RandomOne() {
		double randomD = Math.random() * (1 + 1 + 1) - 1;
		int random = (int) Math.round(randomD);
		return random;
	}

	// Srednia dla kolumn
	public static void ShowArr(int arr[]) {
		int wielokrotnosc = 1;
		float srednia[] = new float[10];
		for (int i = 0; i < 100; i++) {
			if (i == 10 * wielokrotnosc) {
				System.out.println();
				System.out.print(arr[i] + ",");
				wielokrotnosc++;
			} else if (i < 10) {
				System.out.print("0" + arr[i] + ",");
			} else {
				System.out.print(arr[i] + ",");
			}
		}
		System.out.println();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				srednia[i] += arr[j * 10];
			}
			srednia[i] /= 10;
		}
		for (float x : srednia) {
			System.out.print(x + ", ");
		}

	}

	public static void ShowArr2D(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] MakeArr2D() {
		Random r = new Random();
		double wylosowana = Math.random() * (20 - 10 + 1) + 10;
		int wylosowanaInt = (int) Math.round(wylosowana), random = 0, przekatna = 0;
		boolean przypisano = true;
		int dlugosc = wylosowanaInt;
		int Arr2D[][] = new int[dlugosc][dlugosc];

		for (int i = 0; i < dlugosc; i++) {
			random = RandomNumber();
			for (int j = 0; j < dlugosc; j++) {
				if (przekatna == j && przypisano) {
					if (r.nextBoolean()) {
						Arr2D[i][j] = 1;
					} else {
						Arr2D[i][j] = -1;
					}
					przekatna++;
					przypisano = false;
				} else {
					Arr2D[i][j] = RandomNumber();
				}
			}
			przypisano = true;

		}
		return Arr2D;
	}

	public static void StosunekKolumn(int arr[][]) {
		int wiersze = arr.length, kolumny = arr[0].length;
		double stosunekSum = 0, parzystaSuma = 0, nieparzystaSuma = 0;
		for (int i = 0; i < wiersze; i++) {
			for (int j = 0; j < kolumny; j++) {
				if ((i + j) % 2 == 0) {
					parzystaSuma += arr[i][j];
				} else {
					nieparzystaSuma += arr[i][j];
				}
			}
		}

		nieparzystaSuma = Math.abs(nieparzystaSuma);
		parzystaSuma = Math.abs(parzystaSuma);
		stosunekSum = parzystaSuma / nieparzystaSuma;
		System.out.println("Suma liczb o parzystych indeksach: " + parzystaSuma);
		System.out.println("Suma liczb o nieparzystych indeksach: " + nieparzystaSuma);
		System.out.print("Stosunek sumy liczb o parzystych indeskach do nieparzystych indeksów wynosi: " + stosunekSum);

	}

	public static Okrag[] TablicaOkregow(int ilosc) {
		Okrag[] tablica = new Okrag[ilosc];
		for (int i = 0; i < ilosc; i++) {
			tablica[i] = new Okrag(i);
		}
		return tablica;
	}

	public static void SprawdzPolozenie(Okrag o1, Okrag o2) {
		double sumaPromieni = o1.promien + o2.promien;
		double roznicaPromieni = Math.abs(o1.promien - o2.promien);
		double odlegosc = Math.sqrt(((o2.x - o1.x) * (o2.x - o1.x)) + ((o2.y - o1.y) * (o2.y - o1.y)));
		System.out.println("Okrag " + o1.numer + " oraz okrag " + o2.numer + " sa:");
		if (odlegosc == sumaPromieni) {
			System.out.println("Okregi sa styczne zewnetrznie");
		} else if (odlegosc > sumaPromieni) {
			System.out.println("Okregi sa rozlaczne zewnetrznie");
		} else if (odlegosc < roznicaPromieni) {
			System.out.println("Okregi sa rozlaczne wewnetrznie");
		} else if (odlegosc == roznicaPromieni) {
			System.out.println("Okregi sa styczne wewnetrznie");
		} else if (roznicaPromieni < odlegosc && odlegosc < sumaPromieni) {
			System.out.println("Okregi sie przecinaja");
		}
	}

	public static void WyswietlOkregi(Okrag[] tab) {
		for (Okrag o : tab) {
			System.out.println("x: " + o.x + ", y: " + o.y + ", promien: " + o.promien);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean program = true;
		int wybor, ilosc;
		Okrag[] tablicaO = null;
		int tablica2D[][] = null;
		int tablica[] = null;
		

		while (program) {

			System.out.println(
					"\n1.Tablica 1D\n2.Tablica 2D\n3.Stosunek liczb o indeksach parzystych do indeksow nieparzystych\n4.Stworz tablice okregow\n5.Wyswietl stosunki okregow");
			wybor = scanner.nextInt();
			
			switch (wybor) {

			case 1:
				tablica = MakeArr();
				ShowArr(tablica);
				System.out.println();
				break;
				
			case 2:
				tablica2D = MakeArr2D();
				ShowArr2D(tablica2D);
				System.out.println();
				break;
				
			case 3:
				StosunekKolumn(tablica2D);
				System.out.println();
				break;
				
			case 4:
				System.out.println("Podaj ile okregow chcesz stworzyc: ");
				ilosc = scanner.nextInt();
				tablicaO = TablicaOkregow(ilosc);
				WyswietlOkregi(tablicaO);
				System.out.println();
				break;
				
			case 5:
				LinkedList<Okrag> temp = new LinkedList<>(Arrays.asList(tablicaO));

				for (int i = 0; i < tablicaO.length - 1; i++) {
					for (int j = 0; j < temp.size(); j++) {
						if (tablicaO[i].numer != temp.get(j).numer) {
							SprawdzPolozenie(tablicaO[i], temp.get(j));
						}
					}
					temp.removeFirst();
				}
				System.out.println();
				break;
				
			default:
				System.out.println("Program konczy prace.");
				program = false;
				break;
			}
		}

	}
}
