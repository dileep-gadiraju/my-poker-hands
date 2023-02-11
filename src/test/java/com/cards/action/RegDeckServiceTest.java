package com.cards.action;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cards.model.Card;
import com.cards.model.DeckOfCards;
import com.cards.model.RegDeckOfCards;
import com.cards.service.DeckService;
import com.cards.service.RegDeckService;

class RegDeckServiceTest {
	
	private DeckOfCards deck;
	private DeckService service;
	
	@BeforeEach
	void  setUp() throws Exception {
		deck=new RegDeckOfCards();
		service=RegDeckService.getInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		deck=null;
		service=null;
	}

	
	@Test
	void testShuffleDistribute() {
		DeckOfCards shuffled=service.shuffleDeck(deck);
		List<Card> cards=service.distribute(shuffled,5);
		assertEquals(cards.size(), 5);
		
	}
	
	
}
