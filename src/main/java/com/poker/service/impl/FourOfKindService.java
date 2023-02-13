package com.poker.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poker.model.Card;
import com.poker.model.PokerHand;
import com.poker.model.Rank;
import com.poker.service.PokerHandsService;

public class FourOfKindService implements PokerHandsService {

	private FourOfKindService() {
	}

	public static final FourOfKindService INSTANCE;
	static {
		INSTANCE = new FourOfKindService();
	}

	@Override
	public PokerHand solve(List<Card> cards) {
		Collections.sort(cards);
		boolean fourOfKindFound = false;
		PokerHand hand = null;
		Map<Rank, List<Card>> map = new HashMap<>();
		for (Card c : cards) {
			if (map.containsKey(c.getRank())) {
				map.get(c.getRank()).add(c);
			} else {
				List<Card> list = new ArrayList<>();
				list.add(c);
				map.put(c.getRank(), list);
			}
		}
		for (Rank r : map.keySet()) {
			if (map.get(r).size() == 4) {
				fourOfKindFound = true;
				break;
			}
		}
		if (cards.size() > 0 && cards.size() <= 5 && fourOfKindFound) {
			hand = PokerHand.FOUR_OF_A_KIND;
		}
		return hand;
	}

}
