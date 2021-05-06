
public class map {
	protected static String[][] oceanMap = new String[10][10]; // Ocean Map >> 2d Array 10 x 10
	protected static String[][] oceanMapNoShips = new String[10][10]; // Ocean Map >> 2d Array 10 x 10
	protected static String[][] compOceanMapNoShips = new String[10][10]; // Ocean Map >> 2d Array 10 x 10
	protected static String[][] compOceanMap = new String[10][10]; // Computer Ocean Map >> 2d Array 10 x 10
	
	
	protected static void mapMaker() {
		// Create Numbers on the map
		System.out.println("   ABCDEFGHIJ");
		for (int row = 0; row < oceanMap.length; row++) {
			System.out.print(row + " |");
			for (int col = 0; col < oceanMap[row].length; col++) {
				if (oceanMap[row][col] == null) {
					System.out.print(" ");
				} else {
					System.out.print(oceanMap[row][col]);
				}
			}
			System.out.println(" |" + row);
		}
		System.out.println("   ABCDEFGHIJ");
		System.out.println();

	}

	protected static void mapMakerNoShips() {
		// Create Letters on the map
		System.out.println("  ABCDEFGHIJ");
		for (int row = 0; row < oceanMapNoShips.length; row++) {
			System.out.print(row + "|");
			for (int col = 0; col < oceanMapNoShips[row].length; col++) {
				if (oceanMapNoShips[row][col] == null) {
					System.out.print(" ");
				} else {
					System.out.print(oceanMapNoShips[row][col]);
				}
			}
			System.out.println("|" + row);
		}
		System.out.println("  ABCDEFGHIJ");
	}
	
	
	static void compMapMakerNoShips() {
		// Create Numbers on the map
		System.out.println("  ABCDEFGHIJ");
		for (int row = 0; row < compOceanMapNoShips.length; row++) {
			System.out.print(row + "|");
			for (int col = 0; col < compOceanMapNoShips[row].length; col++) {
				if (compOceanMapNoShips[row][col] == null) {
					System.out.print(" ");
				} else {
					System.out.print(compOceanMapNoShips[row][col]);
				}
			}
			System.out.println("|" + row);
		}
		System.out.println("  ABCDEFGHIJ");
	}

	static void mapMakerComputer() {
		// Create Numbers on the map
		System.out.println("  ABCDEFGHIJ");
		for (int row = 0; row < compOceanMap.length; row++) {
			System.out.print(row + "|");
			for (int col = 0; col < compOceanMap[row].length; col++) {
				if (compOceanMap[row][col] == null) {
					System.out.print(" ");
				} else {
					System.out.print(compOceanMap[row][col]);
				}
			}
			System.out.println("|" + row);
		}
		System.out.println("  ABCDEFGHIJ");
	}
	

public static void main(String[] args) {
	mapMaker();	
}
}
