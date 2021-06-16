package com.tw.academy;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import sun.security.x509.OtherName;
import static org.assertj.core.api.Assertions.*;

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


}
