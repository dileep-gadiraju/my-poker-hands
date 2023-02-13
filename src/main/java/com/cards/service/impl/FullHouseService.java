package com.cards.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cards.model.Card;
import com.cards.model.PokerHand;
import com.cards.model.Rank;
import com.cards.service.PokerHandsService;

public class FullHouseService implements PokerHandsService {
	private FullHouseService() {
	}

	public static final FullHouseService INSTANCE;
	static {
		INSTANCE = new FullHouseService();
	}

	@Override
	public PokerHand solve(List<Card> cards) {
		PokerHand hand = null;
		Collections.sort(cards);
		int match = 0;
		boolean isThreeFound=false;
		boolean isTwoFound=false;
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
			if (!isThreeFound && match < 2 && map.get(r).size() == 3) {
				match++;
				isThreeFound=true;
			}
			if (!isTwoFound && match < 2 && map.get(r).size() == 2) {
				match++;
				isTwoFound=true;
			}			
		}
		if (cards.size() > 0 && cards.size() <= 5 && match == 2) {
			hand = PokerHand.FULL_HOUSE;
		}
		return hand;
	}

}
