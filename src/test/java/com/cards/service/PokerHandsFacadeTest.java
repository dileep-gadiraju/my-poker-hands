package com.cards.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cards.model.Card;
import com.cards.model.PokerHand;
import com.cards.model.Rank;
import com.cards.model.Suit;

class PokerHandsFacadeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testStraightFlush() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.FIVE, Suit.CLUBS));
		cards.add(new Card(Rank.FOUR, Suit.CLUBS));
		cards.add(new Card(Rank.SIX, Suit.CLUBS));
		cards.add(new Card(Rank.SEVEN, Suit.CLUBS));
		cards.add(new Card(Rank.EIGHT, Suit.CLUBS));
		assertEquals(PokerHandsFacade.INSTANCE.solve(cards), PokerHand.STRAIGHT_FLUSH);
	}

}
