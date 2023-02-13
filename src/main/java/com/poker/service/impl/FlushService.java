package com.poker.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import com.poker.model.Card;
import com.poker.model.PokerHand;
import com.poker.service.PokerHandsService;

public class FlushService implements PokerHandsService {

	private FlushService() {
	}

	public static final FlushService INSTANCE;
	static {
		INSTANCE = new FlushService();
	}

	@Override
	public PokerHand solve(List<Card> cards) {
		PokerHand hand = null;
		Collections.sort(cards);
		boolean isFlush = cards.size() > 0 && cards.size() <= 5
				&& IntStream.range(0, 4).allMatch(idx -> cards.get(idx + 1).getSuit() == cards.get(idx).getSuit())
				&& IntStream.range(0, 4).anyMatch(idx -> cards.get(idx + 1).getRank() != cards.get(idx).getRank());
		if (isFlush) {
			hand = PokerHand.FLUSH;
		}
		return hand;
	}

}
