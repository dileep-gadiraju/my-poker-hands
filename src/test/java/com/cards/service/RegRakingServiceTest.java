package com.cards.service;

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

	private DeckService service;
	private RankingService rankingService;

	@BeforeEach
	void setUp() throws Exception {
		service = RegDeckService.getInstance();
		rankingService=RegRankingService.getInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		service=null;
	}

	@Test
	void testRoyalFlushPositive() {
		 List<Card> cards=new ArrayList<>();
		 cards.add(new Card(Rank.TEN,Suit.HEART));
		 cards.add(new Card(Rank.JACK,Suit.HEART));
		 cards.add(new Card(Rank.QUEEN,Suit.HEART));
		 cards.add(new Card(Rank.KING,Suit.HEART));
		 cards.add(new Card(Rank.ACE,Suit.HEART));
		 
		 assertTrue(rankingService.isRoyalFlush(cards),"Royal Flush Test");
	}

}
