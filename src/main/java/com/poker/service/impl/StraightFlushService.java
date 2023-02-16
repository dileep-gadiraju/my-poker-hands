package com.poker.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import com.poker.model.Card;
import com.poker.model.PokerHand;
import com.poker.service.PokerHandsService;

public class StraightFlushService implements PokerHandsService {

	private StraightFlushService() {
	}

	public static final StraightFlushService INSTANCE;
	static {
		INSTANCE = new StraightFlushService();
	}

	@Override
	public PokerHand solve(List<Card> cards) {
		Collections.sort(cards);
		boolean isStraightFlush = cards.size() > 0 && cards.size() <= 5 && IntStream.range(0, 4).allMatch(
				idx -> cards.get(idx + 1).getRank().ordinal() - cards.get(idx).getRank().ordinal() == 1
						&& cards.get(idx + 1).getSuit() == cards.get(idx).getSuit());

		return isStraightFlush ? PokerHand.STRAIGHT_FLUSH : null;
	}

}
