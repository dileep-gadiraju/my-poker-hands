package com.poker.facade;

import java.util.List;

import com.poker.model.Card;
import com.poker.model.PokerHand;
import com.poker.service.PokerHandsService;
import com.poker.service.impl.FlushService;
import com.poker.service.impl.FourOfKindService;
import com.poker.service.impl.FullHouseService;
import com.poker.service.impl.HighCardService;
import com.poker.service.impl.PairService;
import com.poker.service.impl.RoyalFlushService;
import com.poker.service.impl.StraightFlushService;
import com.poker.service.impl.StraightService;
import com.poker.service.impl.ThreeOfKindService;
import com.poker.service.impl.TwoPairsService;

public class PokerHandsFacade {
	public static PokerHandsFacade INSTANCE = new PokerHandsFacade();
	private PokerHandsService[] services = { RoyalFlushService.INSTANCE, StraightFlushService.INSTANCE,
			FourOfKindService.INSTANCE, FullHouseService.INSTANCE, FlushService.INSTANCE, StraightService.INSTANCE,
			ThreeOfKindService.INSTANCE, TwoPairsService.INSTANCE, PairService.INSTANCE, HighCardService.INSTANCE };

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
