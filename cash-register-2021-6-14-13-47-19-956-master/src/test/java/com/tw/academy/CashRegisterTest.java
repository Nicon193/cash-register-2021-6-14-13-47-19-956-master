package com.tw.academy;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.*;

class CashRegisterTest {
	@Test
	void should_call_print_when_process_given_purchase() {
		//given
		Purchase purchase = new Purchase();
		Printer  print= mock (Printer.class);
		CashRegister cashRegister = new CashRegister(print);
		//when
		cashRegister.process(purchase);
		//then
		//verify that cashRegister.process will trigger print
		verify(print,times(1)).print(anyString());
	}
	@Test
	void should_print_purchase_when_process_given_purchase() {
		//given
		Purchase purchase = mock(Purchase.class);
		Printer  print= mock (Printer.class);
		CashRegister cashRegister = new CashRegister(print);
		//when
		when(purchase.asString()).thenReturn("123");
		cashRegister.process(purchase);

		//then
		//verify that cashRegister.process will trigger print
		verify(print).print("123");
	}

	@Test
	void should_call_print_when_process_given_purchase1() {
		//given
		SpyPrinter spyPrinter = new SpyPrinter();
		Purchase purchase = new Purchase();
		CashRegister cashRegister = new CashRegister(spyPrinter);

		//when
		cashRegister.process(purchase);
		//then
		assertEquals(1, spyPrinter.count);
	}

	@Test
	void should_print_purchase_when_process_given_purchase2() {
		//given
		SpyPrinter spyPrinter = new SpyPrinter();
		SpyPurchase spyPurchase = new SpyPurchase();
		CashRegister cashRegister = new CashRegister(spyPrinter);
		spyPurchase.content = "123";
		//when
		cashRegister.process(spyPurchase);
		//then
		assertEquals("123", spyPrinter.content);
	}

	private static class SpyPrinter extends Printer{
		int count = 0;
		String content;
		@Override
		public void print(String content) {
			count++;
			this.content = content;
		}
	}

	private static class SpyPurchase extends Purchase{
		String content;
		@Override
		public String asString() {
			return content;
		}
	}
}
