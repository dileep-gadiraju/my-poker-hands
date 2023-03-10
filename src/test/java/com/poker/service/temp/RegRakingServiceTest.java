package com.poker.service.temp;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.poker.model.Card;
import com.poker.model.Rank;
import com.poker.model.Suit;
import com.poker.service.temp.RankingService;
import com.poker.service.temp.RegRankingService;

class RegRakingServiceTest {

	private RankingService rankingService;

	@BeforeEach
	void setUp() throws Exception {
		rankingService = RegRankingService.getInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		rankingService = null;
	}

	@Test
	void testRoyalFlush_Unordered_Heart_Positive() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.JACK, Suit.HEARTS));
		cards.add(new Card(Rank.QUEEN, Suit.HEARTS));
		cards.add(new Card(Rank.KING, Suit.HEARTS));
		cards.add(new Card(Rank.TEN, Suit.HEARTS));
		cards.add(new Card(Rank.ACE, Suit.HEARTS));

		assertTrue(rankingService.isRoyalFlush(cards), "Royal Flush Positive Test");
	}

	@Test
	void testRoyalFlush_Spade__Positive() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.TEN, Suit.SPADES));
		cards.add(new Card(Rank.JACK, Suit.SPADES));
		cards.add(new Card(Rank.QUEEN, Suit.SPADES));
		cards.add(new Card(Rank.ACE, Suit.SPADES));
		cards.add(new Card(Rank.KING, Suit.SPADES));

		assertTrue(rankingService.isRoyalFlush(cards), "Royal Flush Positive Test");
	}

	@Test
	void testRoyalFlush_MultiSuit__Negative() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.TEN, Suit.SPADES));
		cards.add(new Card(Rank.JACK, Suit.HEARTS));
		cards.add(new Card(Rank.QUEEN, Suit.CLUBS));
		cards.add(new Card(Rank.KING, Suit.DAIMONDS));
		cards.add(new Card(Rank.ACE, Suit.DAIMONDS));

		assertFalse(rankingService.isRoyalFlush(cards));
	}

	@Test
	void testRoyalFlush_WrongRanks__Negative() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.FIVE, Suit.SPADES));
		cards.add(new Card(Rank.SIX, Suit.SPADES));
		cards.add(new Card(Rank.SEVEN, Suit.SPADES));
		cards.add(new Card(Rank.EIGHT, Suit.SPADES));
		cards.add(new Card(Rank.NINE, Suit.SPADES));

		assertFalse(rankingService.isRoyalFlush(cards));
	}

	@Test
	void testRoyalFlushNegative() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.ACE, Suit.HEARTS));
		cards.add(new Card(Rank.TWO, Suit.HEARTS));
		cards.add(new Card(Rank.THREE, Suit.HEARTS));
		cards.add(new Card(Rank.FOUR, Suit.HEARTS));
		cards.add(new Card(Rank.FIVE, Suit.HEARTS));

		assertFalse(rankingService.isRoyalFlush(cards));
	}

	@Test
	void testStraightFlush_UnorderedRank_Positive() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.FIVE, Suit.CLUBS));
		cards.add(new Card(Rank.FOUR, Suit.CLUBS));
		cards.add(new Card(Rank.SIX, Suit.CLUBS));
		cards.add(new Card(Rank.SEVEN, Suit.CLUBS));
		cards.add(new Card(Rank.EIGHT, Suit.CLUBS));
		assertTrue(rankingService.isStraightFlush(cards), "Straight Flush Positive");
	}

	@Test
	void testFlushNegative() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.NINE, Suit.CLUBS));
		cards.add(new Card(Rank.ACE, Suit.CLUBS));
		cards.add(new Card(Rank.FIVE, Suit.CLUBS));
		cards.add(new Card(Rank.TEN, Suit.CLUBS));
		cards.add(new Card(Rank.TWO, Suit.SPADES));
		assertFalse(rankingService.isFlush(cards));
	}

	@Test
	void testPair_Positive() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.NINE, Suit.CLUBS));
		cards.add(new Card(Rank.SIX, Suit.CLUBS));
		cards.add(new Card(Rank.TWO, Suit.CLUBS));
		cards.add(new Card(Rank.TEN, Suit.CLUBS));
		cards.add(new Card(Rank.TWO, Suit.SPADES));
		assertTrue(rankingService.isPair(cards));		
	}
	
}
