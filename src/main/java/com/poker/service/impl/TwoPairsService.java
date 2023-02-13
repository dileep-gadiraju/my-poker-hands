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

public class TwoPairsService implements PokerHandsService {

	private TwoPairsService() {
	}

	public static final TwoPairsService INSTANCE;
	static {
		INSTANCE = new TwoPairsService();
	}

	@Override
	public PokerHand solve(List<Card> cards) {
		PokerHand hand = null;
		Collections.sort(cards);
		int pairFoundCount = 0;
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
			if (pairFoundCount < 2 && map.get(r).size() == 2) {
				pairFoundCount++;
			}
		}
		if (cards.size() > 0 && cards.size() <= 5 && pairFoundCount == 2) {
			hand = PokerHand.TWO_PAIR;
		}
		return hand;
	}

}
