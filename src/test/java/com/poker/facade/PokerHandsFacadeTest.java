package com.poker.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.poker.facade.PokerHandsFacade;
import com.poker.model.Card;
import com.poker.model.PokerHand;
import com.poker.model.Rank;
import com.poker.model.Suit;

class PokerHandsFacadeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRoyalFlush() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.JACK, Suit.HEARTS));
		cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
		cards.add(new Card(Rank.KING, Suit.HEARTS));
		cards.add(new Card(Rank.TEN, Suit.HEARTS));
		cards.add(new Card(Rank.ACE, Suit.HEARTS));
		assertEquals(PokerHandsFacade.INSTANCE.solve(cards), PokerHand.ROYAL_FLUSH);
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

	@Test
	void testFourOfKindFlush() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.FIVE, Suit.CLUBS));
		cards.add(new Card(Rank.FIVE, Suit.DAIMONDS));
		cards.add(new Card(Rank.EIGHT, Suit.SPADES));
		cards.add(new Card(Rank.FIVE, Suit.HEARTS));
		cards.add(new Card(Rank.FIVE, Suit.CLUBS));
		assertEquals(PokerHand.FOUR_OF_A_KIND, PokerHandsFacade.INSTANCE.solve(cards));
	}

	@Test
	void testFullHouse() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.JACK, Suit.HEARTS));
		cards.add(new Card(Rank.SIX, Suit.SPADES));
		cards.add(new Card(Rank.SIX, Suit.HEARTS));
		cards.add(new Card(Rank.JACK, Suit.DAIMONDS));
		cards.add(new Card(Rank.JACK, Suit.CLUBS));
		assertEquals(PokerHandsFacade.INSTANCE.solve(cards), PokerHand.FULL_HOUSE);
	}

	@Test
	void testFlush() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.TWO, Suit.HEARTS));
		cards.add(new Card(Rank.SEVEN, Suit.HEARTS));
		cards.add(new Card(Rank.EIGHT, Suit.HEARTS));
		cards.add(new Card(Rank.FIVE, Suit.HEARTS));
		cards.add(new Card(Rank.ACE, Suit.HEARTS));
		assertEquals(PokerHand.FLUSH, PokerHandsFacade.INSTANCE.solve(cards));
	}

	@Test
	void testStraight() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.TWO, Suit.HEARTS));
		cards.add(new Card(Rank.SIX, Suit.DAIMONDS));
		cards.add(new Card(Rank.FIVE, Suit.HEARTS));
		cards.add(new Card(Rank.FOUR, Suit.HEARTS));
		cards.add(new Card(Rank.THREE, Suit.HEARTS));
		assertEquals(PokerHand.STRAIGHT, PokerHandsFacade.INSTANCE.solve(cards));
	}

	@Test
	void testThreeOfKind() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.SIX, Suit.HEARTS));
		cards.add(new Card(Rank.QUEEN, Suit.SPADES));
		cards.add(new Card(Rank.KING, Suit.HEARTS));
		cards.add(new Card(Rank.SIX, Suit.DAIMONDS));
		cards.add(new Card(Rank.SIX, Suit.CLUBS));
		assertEquals(PokerHand.THREE_OF_KIND, PokerHandsFacade.INSTANCE.solve(cards));
	}

	@Test
	void testTwoPair() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.JACK, Suit.HEARTS));
		cards.add(new Card(Rank.QUEEN, Suit.SPADES));
		cards.add(new Card(Rank.KING, Suit.HEARTS));
		cards.add(new Card(Rank.QUEEN, Suit.DAIMONDS));
		cards.add(new Card(Rank.JACK, Suit.CLUBS));
		assertEquals(PokerHand.TWO_PAIR, PokerHandsFacade.INSTANCE.solve(cards));
	}

	@Test
	void testPair() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.JACK, Suit.HEARTS));
		cards.add(new Card(Rank.TWO, Suit.SPADES));
		cards.add(new Card(Rank.KING, Suit.HEARTS));
		cards.add(new Card(Rank.QUEEN, Suit.DAIMONDS));
		cards.add(new Card(Rank.JACK, Suit.CLUBS));
		assertEquals(PokerHand.PAIR, PokerHandsFacade.INSTANCE.solve(cards));
	}

	@Test
	void testHardCard() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.THREE, Suit.SPADES));
		cards.add(new Card(Rank.FIVE, Suit.HEARTS));
		cards.add(new Card(Rank.SEVEN, Suit.DAIMONDS));
		cards.add(new Card(Rank.NINE, Suit.CLUBS));
		cards.add(new Card(Rank.JACK, Suit.SPADES));
		assertEquals(PokerHand.HIGH_CARD, PokerHandsFacade.INSTANCE.solve(cards));
	}

}
