package by.pvt.medvedeva.education.filter;

import java.util.regex.Pattern;

/**
 * Проверяет данные на корректность <br/>
 * Validates data
 *
 *
 */
public class FormDataValidator {

	/**
	 * Только латинские или только русские буквы вплоть до 15-и символов <br/>
	 * Only latin or only russian letters up to 15 symbols
	 */
	public static final Pattern namePattern = Pattern.compile("(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[\\u0410-\\u042f]?[\\u0430-\\u044f]{1,15}\\z)");

	/**
	 * Только латинские или только русские буквы вплоть до 15-и символов <br/>
	 * Only latin or only russian letters up to 15 symbols
	 */
	public static final Pattern surnamePattern = Pattern.compile("(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[\\u0410-\\u042f]?[\\u0430-\\u044f]{1,15}\\z)");

	/**
	 * Латинские буквы или цифры, от 3-х до 15-и символов <br/>
	 * Latin letters or digits at least 3 symbols up to 15
	 */
	public static final Pattern loginPattern = Pattern.compile("\\A[a-zA-Z0-9]{3,15}\\z");

	/**
	 * Латинские буквы, цифры, *, ! или ^,<br/>
	 * от 6-и до 15-и символов <br/>
	 * Latin letters, digits, *, ! or ^ at least 6<br/>
	 * symbols up to 15
	 */
	public static final Pattern passwordPattern = Pattern.compile("\\A[a-zA-Z0-9_\\*\\!\\^]{6,15}\\z");

	/**
	 * только одна цифра от 1 до 6
	 */
	public static final Pattern levelPattern = Pattern.compile("^([1-6]{1,1})$");

	/**
	 * только числа с десятичной частью
	 */
	public static final Pattern averagePattern = Pattern.compile("([0-9]\\.[0-9]+)");
	/**
	 * любое количество цифр
	 */
	public static final Pattern cardPattern = Pattern.compile("[\\d]+");

}
