package com.cards.facade;

import java.util.List;

import com.cards.model.Card;
import com.cards.model.PokerHand;
import com.cards.service.PokerHandsService;
import com.cards.service.impl.FlushService;
import com.cards.service.impl.FourOfKindService;
import com.cards.service.impl.FullHouseService;
import com.cards.service.impl.HighCardService;
import com.cards.service.impl.PairService;
import com.cards.service.impl.RoyalFlushService;
import com.cards.service.impl.StraightFlushService;
import com.cards.service.impl.StraightService;
import com.cards.service.impl.TwoPairsService;

public class PokerHandsFacade {
	public static PokerHandsFacade INSTANCE = new PokerHandsFacade();
	private PokerHandsService[] services = { RoyalFlushService.INSTANCE, StraightFlushService.INSTANCE,
			FourOfKindService.INSTANCE, FullHouseService.INSTANCE, FlushService.INSTANCE, StraightService.INSTANCE,
			TwoPairsService.INSTANCE, PairService.INSTANCE, HighCardService.INSTANCE };

	private PokerHandsFacade() {

	}

	public PokerHand solve(List<Card> cards) {
		PokerHand hand = null;
		for (PokerHandsService service : services) {
			hand = service.solve(cards);
			if (hand != null) {
				break;
			}
		}
		return hand;
	}
}
