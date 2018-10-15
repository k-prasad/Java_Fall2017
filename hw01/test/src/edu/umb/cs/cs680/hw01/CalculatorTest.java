package edu.umb.cs.cs680.hw01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import edu.umb.cs.cs680.hw01.Calculator;

public class CalculatorTest {

	@Test
	public void multiply3By4() {
		Calculator cut = new Calculator();
		float expected = 12;
		float actual = cut.multiply(3, 4);
		assertThat(actual, is(expected));
	}

	@Test
	public void divide3By2() {
		Calculator cut = new Calculator();
		float expected = 1.5f;
		float actual = cut.divide(3, 2);
		assertThat(actual, is(expected));
	}

	@Test
	public void divide22By7() {
		Calculator cut = new Calculator();
		float expected = 3.142857142857143f;
		float actual = cut.divide(22f, 7f);
		assertThat(actual, is(expected));
	}

	@Test
	public void multiply5_4By7_1() {
		Calculator cut = new Calculator();
		float expected = 38.34f;
		float actual = cut.multiply(5.4f, 7.1f);
		assertThat(actual, is(expected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void divide5By0() {
		Calculator cut = new Calculator();
		cut.divide(5, 0);
	}

}
