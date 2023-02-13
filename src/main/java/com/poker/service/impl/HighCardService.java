package com.poker.service.impl;

import java.util.List;

import com.poker.model.Card;
import com.poker.model.PokerHand;
import com.poker.service.PokerHandsService;

public class HighCardService implements PokerHandsService {

	private HighCardService() {
	}

	public static final HighCardService INSTANCE;
	static {
		INSTANCE = new HighCardService();
	}

	@Override
	public PokerHand solve(List<Card> cards) {
		return PokerHand.HIGH_CARD;
	}

}
