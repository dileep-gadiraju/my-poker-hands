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

public class ThreeOfKindService implements PokerHandsService {
	
	private ThreeOfKindService() {}
	public static ThreeOfKindService INSTANCE;
	static {
		INSTANCE=new ThreeOfKindService();
	}

	@Override
	public PokerHand solve(List<Card> cards) {
		PokerHand hand=null;
		Collections.sort(cards);
		boolean threeOfKindFound = false;
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
			if (map.get(r).size() == 3) {
				threeOfKindFound=true;
				break;
			}
		}
		if(cards.size() > 0 && cards.size() <= 5 && threeOfKindFound)
		{
			hand=PokerHand.THREE_OF_KIND;
		}
		return hand;
	}

}
