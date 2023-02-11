package com.cards.service;

import java.util.List;

import com.cards.model.Card;
import com.cards.model.Rank;
import com.cards.model.Suit;

public class RegRankingService implements RankingService {
	
	private static RegRankingService service;
	private RegRankingService() {
		
	}
	public static RegRankingService getInstance()
	{
		if(service==null) {
			service=new RegRankingService();
		}
		return service;
	}

	@Override
	public boolean isRoyalFlush(List<Card> cards) {
		boolean isRoyalFlush = cards.size() == 5
				&& (cards.get(0).getRank() == Rank.TEN && cards.get(0).getSuit() == Suit.HEART)
				&& (cards.get(1).getRank() == Rank.JACK && cards.get(1).getSuit() == Suit.HEART)
				&& (cards.get(2).getRank() == Rank.QUEEN && cards.get(2).getSuit() == Suit.HEART)
				&& (cards.get(3).getRank() == Rank.KING && cards.get(3).getSuit() == Suit.HEART)
				&& (cards.get(4).getRank() == Rank.ACE && cards.get(4).getSuit() == Suit.HEART);
		return isRoyalFlush;
	}

	@Override
	public boolean isStraightFlush(List<Card> cards) {
		boolean isStraightFlush = cards.size() == 5
				&& (cards.get(0).getRank() == Rank.FOUR && cards.get(0).getSuit() == Suit.CLUBS)
				&& (cards.get(1).getRank() == Rank.FIVE && cards.get(1).getSuit() == Suit.CLUBS)
				&& (cards.get(2).getRank() == Rank.SIX && cards.get(2).getSuit() == Suit.CLUBS)
				&& (cards.get(3).getRank() == Rank.SEVEN && cards.get(3).getSuit() == Suit.CLUBS)
				&& (cards.get(4).getRank() == Rank.EIGHT && cards.get(4).getSuit() == Suit.CLUBS);
		return isStraightFlush;
	}

}
