package com.cards.service;

import java.util.List;

import com.cards.model.Card;
import com.cards.model.PokerHand;

public class PokerHandsFacade {
	public static PokerHandsFacade INSTANCE = new PokerHandsFacade();
	private PokerHandService[] services = { RoyalFlushService.INSTANCE, StraightFlushService.INSTANCE };

	private PokerHandsFacade() {

	}

	public PokerHand solve(List<Card> cards) {
		PokerHand hand = null;
		for (PokerHandService service : services) {
			hand=service.solve(cards);
			if(hand!=null)
			{
				break;
			}
		}
		return hand;
	}
}
