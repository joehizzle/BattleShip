import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

class BattleShipsTest {

	@Test
	public void testconvertLetterToInt() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method method = BattleShips.class.getDeclaredMethod("convertLetterToInt", String.class);
		method.setAccessible(true);
		BattleShips battleships = new BattleShips();
		int convert= (int)method.invoke(battleships, "A");
		assertEquals(0,convert);
	}

	@Test
	public void testconvertLetterToIntfail() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method method = BattleShips.class.getDeclaredMethod("convertLetterToInt", String.class);
		method.setAccessible(true);
		BattleShips battleships = new BattleShips();
		int convert= (int)method.invoke(battleships, "B");
		assertEquals(0,convert);
	}

	@Test
	public void testconvertIntToLetter() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method method = BattleShips.class.getDeclaredMethod("convertIntToLetter",int.class);
		method.setAccessible(true);
		BattleShips battleships = new BattleShips();
		String convert= (String)method.invoke(battleships,0);
		assertEquals("A",convert);
	}
	
	@Test
	public void testconvertIntToLetterfail() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method method = BattleShips.class.getDeclaredMethod("convertIntToLetter", int.class);
		method.setAccessible(true);
		BattleShips battleships = new BattleShips();
		String convert= (String)method.invoke(battleships,0);
		assertEquals("B",convert);
	}

}
