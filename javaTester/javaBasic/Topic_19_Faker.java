package javaBasic;

import java.util.Locale;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class Topic_19_Faker {

	public static void main(String[] args) {
		// US
		Faker faker = new Faker();
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName ());
		System.out.println(faker.business().creditCardType());
		System.out.println(faker.business().creditCardNumber());
		System.out.println(faker.business().creditCardExpiry());
		
		// Việt Nam
		Faker fakeVi = new Faker(new Locale("vi"));
		System.out.println(fakeVi.address().firstName());
		System.out.println(fakeVi.address().lastName ());
	}

}
