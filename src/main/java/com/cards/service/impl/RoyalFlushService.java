package com.cards.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import com.cards.model.Card;
import com.cards.model.PokerHand;
import com.cards.model.Rank;
import com.cards.service.PokerHandsService;

public class RoyalFlushService implements PokerHandsService {
	private static List<Rank> royalRanks = Arrays
			.asList(new Rank[] { Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE });
	public static final RoyalFlushService INSTANCE;
	static {
		INSTANCE=new RoyalFlushService();
	}
	private RoyalFlushService() {
		
	}
	@Override
	public PokerHand solve(List<Card> cards) {
		Collections.sort(cards);
		boolean isRoyalFlush = cards.size() > 0 && cards.size() <= 5
				&& IntStream.range(0, 5).allMatch(idx -> cards.get(idx).getRank() == royalRanks.get(idx))
				&& IntStream.range(0, 4).allMatch(idx -> cards.get(idx + 1).getSuit() == cards.get(idx).getSuit());

		return isRoyalFlush ? PokerHand.ROYAL_FLUSH : null;
	}

}
