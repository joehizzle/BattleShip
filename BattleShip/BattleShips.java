
import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleShips {

	protected static Scanner userInput = new Scanner(System.in);
	protected static String errorResponse = "Please enter a letter between A and J";
	protected static String errorResponseLetter = "Please enter a number as you have entered a letter or number not between 0 and 9";
	protected static int checkerXVal = 0;
    protected static int checkerYval = 0;
    protected static String Name;

	
	protected static int convertLetterToInt(String val) {
		int toReturn = -1;
		switch (val) {
		case "A": case "a":
			toReturn = 0;
			break;
		case "B": case "b":
			toReturn = 1;
			break;
		case "C": case "c":
			toReturn = 2;
			break;
		case "D": case "d":
			toReturn = 3;
			break;
		case "E": case "e":
			toReturn = 4;
			break;
		case "F": case "f":
			toReturn = 5;
			break;
		case "G": case "g":
			toReturn = 6;
			break;
		case "H": case "h":
			toReturn = 7;
			break;
		case "I": case "i":
			toReturn = 8;
			break;
		case "J": case "j":
			toReturn = 9;
			break;
		default:
			toReturn = -1;
			break;
		}

		return toReturn;
	}

	private static String convertIntToLetter(int val) {
		String toReturn = "Z";
		switch (val) {
		case 0:
			toReturn = "A";
			break;
		case 1:
			toReturn = "B";
			break;
		case 2:
			toReturn = "C";
			break;
		case 3:
			toReturn = "D";
			break;
		case 4:
			toReturn = "E";
			break;
		case 5:
			toReturn = "F";
			break;
		case 6:
			toReturn = "G";
			break;
		case 7:
			toReturn = "H";
			break;
		case 8:
			toReturn = "I";
			break;
		case 9:
			toReturn = "J";
			break;
		default:
			toReturn = "Z";
			break;
		}

		return toReturn;
	} 
	
	
	protected static int userGuess() {

		boolean userGuessChecker = false;
		boolean userGuessCheckerX = false;
		boolean userGuessCheckerY = false;
		int userGuessX = 0;
		int userGuessY = 0;
		int hitValue = 0;

		System.out.println("Enter your X and Y Co-Ordinates to launch your attack! ");
		System.out.println();

		while (!userGuessChecker && !userGuessCheckerX && !userGuessCheckerY) {
			while (!userGuessCheckerX) {
				try {
					System.out.print("Enter your X value: ");
					userInput.hasNextInt();
					userGuessX = userInput.nextInt();
					if (userGuessX < 10 && userGuessX >= 0) {
						userGuessCheckerX = true;
					} else {
						System.out.println(errorResponse);
					}
				} catch (InputMismatchException exception) {
					System.out.println("This is not an integer");
					userInput.next();
				}
			}
		}
				while (!userGuessCheckerY) {
					System.out.print("Enter your Y value: ");
					String userLtrGuessY = userInput.next();
					userGuessY = convertLetterToInt(userLtrGuessY);
					if (userGuessY < 10 && userGuessY >= 0) {
						userGuessCheckerY = true;
					} else {
						System.out.println(errorResponse);
					}

				}
			

			if (map.compOceanMap[userGuessX][userGuessY] != null) {
				// if cell == 1
				if (map.compOceanMap[userGuessX][userGuessY] == "1") {
					System.out.println("You have already selected this position, please choose again");
					userGuessCheckerX = false;
					userGuessCheckerY = false;
				}
				// if cell == 2
				else if (map.compOceanMap[userGuessX][userGuessY] == "2") {
					System.out.println("The Computer has already chosen this position, please choose again");
					userGuessCheckerX = false;
					userGuessCheckerY = false;
				} else if (map.compOceanMap[userGuessX][userGuessY] == "@") {
					System.out.println("You cant fire on your own position, please choose again");
					userGuessCheckerX = false;
					userGuessCheckerY = false;
				} else if (map.compOceanMap[userGuessX][userGuessY] == "*") {
					System.out.println("The computer has already sunk your ship at this position, please choose again");
					userGuessCheckerX = false;
					userGuessCheckerY = false;
				} else if (map.compOceanMap[userGuessX][userGuessY] == "^") {
					System.out.println("You have already sunk this ship, please choose again");
					userGuessCheckerX = false;
					userGuessCheckerY = false;
				} else {
					// else update the cell
					System.out.println("HIT");
					map.compOceanMap[userGuessX][userGuessY] = "^";
					map.compOceanMapNoShips[userGuessX][userGuessY] = "^";
					hitValue++;
					userGuessChecker = true;
				}

			} else {
				System.out.println("MISS");
				map.compOceanMap[userGuessX][userGuessY] = "1";
				map.compOceanMapNoShips[userGuessX][userGuessY] = "1";
				userGuessChecker = true;
			}

		
		return hitValue;
	}
	
	protected static int compGuess() {

		boolean compGuessChecker = false;
		boolean compGuessCheckerX = false;
		boolean compGuessCheckerY = false;
		int compGuessX = 0;
		int compGuessY = 0;
		int compHitValue = 0;
		String compGuessLtrY;
		Random compGuessNumber = new Random();

		System.out.println("The computer is now attacking");
		System.out.println();

		while (!compGuessChecker && !compGuessCheckerX && !compGuessCheckerY) {
			while (!compGuessCheckerX) {
				compGuessX = (compGuessNumber.nextInt(9));
				if (compGuessX <= 9 && compGuessX >= 0) {
					compGuessCheckerX = true;
					System.out.println(compGuessX);
				} else {
					System.out.println(errorResponse);
				}
			}

			while (!compGuessCheckerY) {
				compGuessY = (compGuessNumber.nextInt(9));
				if (compGuessY <= 9 && compGuessY >= 0) {
					compGuessCheckerY = true;

					compGuessLtrY = convertIntToLetter(compGuessY);
					System.out.println(compGuessLtrY);
				} else {
					System.out.println(errorResponse);
				}

			}
			if (map.oceanMap[compGuessX][compGuessY] != null) {
				// if cell == 1
				if (map.oceanMap[compGuessX][compGuessY] == "1") {
					System.out.println("Player1 has already selected this position, please choose again");
					compGuessCheckerX = false;
					compGuessCheckerY = false;
				}
				// if cell == 2
				else if (map.oceanMap[compGuessX][compGuessY] == "2") {
					System.out.println("You have already chosen this position, please choose again");
					compGuessCheckerX = false;
					compGuessCheckerY = false;
				} else if (map.oceanMap[compGuessX][compGuessY] == "#") {
					System.out.println("You cant fire on your own position, please choose again");
					compGuessCheckerX = false;
					compGuessCheckerY = false;
				} else if (map.oceanMap[compGuessX][compGuessY] == "^") {
					System.out.println("You have already sunk this ship, please choose again");
					compGuessCheckerX = false;
					compGuessCheckerY = false;
				} else if (map.oceanMap[compGuessX][compGuessY] == "*") {
					System.out.println("Player has sunk your ship at this position, please choose again");
					compGuessCheckerX = false;
					compGuessCheckerY = false;
				} else {
					// else update the cell
					System.out.println("HIT");
					map.oceanMap[compGuessX][compGuessY] = "*";
					map.oceanMapNoShips[compGuessX][compGuessY] = "*";
					compHitValue++;
					compGuessChecker = true;
				}

			} else {
				System.out.println("MISS");
				map.oceanMap[compGuessX][compGuessY] = "2";
				map.oceanMapNoShips[compGuessX][compGuessY] = "2";
				compGuessChecker = true;
			}
		}
		return compHitValue;
	}
	
	public static void main(String[] args) {

		System.out.println("----- Welcome to the Battle Ships Game -----");
		System.out.println();

		map.mapMaker();
		Player.userDeployment();
		Player.compDeployment();
		map.mapMakerNoShips();
		Game.startGame();		
		map.compMapMakerNoShips();
		map.mapMakerComputer();
		
		

	}

}
