package com.poker.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import com.poker.model.Card;
import com.poker.model.PokerHand;
import com.poker.service.PokerHandsService;

public class StraightService implements PokerHandsService {

	private StraightService() {
	}

	public static final StraightService INSTANCE;
	static {
		INSTANCE = new StraightService();
	}

	@Override
	public PokerHand solve(List<Card> cards) {
		PokerHand hand = null;
		Collections.sort(cards);
		boolean isStraight = cards.size() > 0 && cards.size() <= 5 && IntStream.range(0, 4).allMatch(
				idx -> Math.abs(cards.get(idx + 1).getRank().ordinal() - cards.get(idx).getRank().ordinal()) == 1)
				&& (cards.get(0).getSuit() != cards.get(4).getSuit() || IntStream.range(0, 4)
						.anyMatch(idx -> cards.get(idx + 1).getSuit() != cards.get(idx).getSuit()));

		if (isStraight) {
			hand = PokerHand.STRAIGHT;
		}

		return hand;
	}

}
