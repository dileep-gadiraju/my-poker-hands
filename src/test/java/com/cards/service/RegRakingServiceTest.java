package com.cards.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cards.model.Card;
import com.cards.model.Rank;
import com.cards.model.Suit;

class RegRakingServiceTest {

	private RankingService rankingService;

	@BeforeEach
	void setUp() throws Exception {
		rankingService=RegRankingService.getInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		rankingService=null;
	}

	@Test
	void testRoyalFlushPositive() {
		 List<Card> cards=new ArrayList<>();
		 cards.add(new Card(Rank.TEN,Suit.HEART));
		 cards.add(new Card(Rank.JACK,Suit.HEART));
		 cards.add(new Card(Rank.QUEEN,Suit.HEART));
		 cards.add(new Card(Rank.KING,Suit.HEART));
		 cards.add(new Card(Rank.ACE,Suit.HEART));
		 
		 assertTrue(rankingService.isRoyalFlush(cards),"Royal Flush Positive Test");
	}

	@Test
	void testRoyalFlushNegative() {
		 List<Card> cards=new ArrayList<>();
		 cards.add(new Card(Rank.TEN,Suit.HEART));
		 cards.add(new Card(Rank.JACK,Suit.HEART));
		 cards.add(new Card(Rank.QUEEN,Suit.HEART));
		 cards.add(new Card(Rank.FIVE,Suit.HEART));
		 cards.add(new Card(Rank.ACE,Suit.HEART));
		 
		 assertFalse(rankingService.isRoyalFlush(cards));
	}
	
	@Test
	void testStraightFlushPositive() {
		 List<Card> cards=new ArrayList<>();
		 cards.add(new Card(Rank.FOUR,Suit.CLUBS));
		 cards.add(new Card(Rank.FIVE,Suit.CLUBS));
		 cards.add(new Card(Rank.SIX,Suit.CLUBS));
		 cards.add(new Card(Rank.SEVEN,Suit.CLUBS));
		 cards.add(new Card(Rank.EIGHT,Suit.CLUBS));
		 assertTrue(rankingService.isStraightFlush(cards),"Straight Flush Positive");
	}

}
