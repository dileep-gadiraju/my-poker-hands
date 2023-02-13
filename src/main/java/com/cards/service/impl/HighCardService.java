package com.cards.service.impl;

import java.util.List;

import com.cards.model.Card;
import com.cards.model.PokerHand;
import com.cards.service.PokerHandsService;

public class HighCardService implements PokerHandsService {

	private HighCardService() {
	}

	public static final HighCardService INSTANCE;
	static {
		INSTANCE = new HighCardService();
	}

	@Override
	public PokerHand solve(List<Card> cards) {
		// TODO Auto-generated method stub
		return null;
	}

}
