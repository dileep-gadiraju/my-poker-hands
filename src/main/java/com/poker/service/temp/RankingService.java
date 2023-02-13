package com.poker.service.temp;

import java.util.List;

import com.poker.model.Card;

public interface RankingService {
	boolean isRoyalFlush(List<Card> cards);
	boolean isStraightFlush(List<Card> cards);
	boolean isFourOfAKind(List<Card> cards);
	boolean isFlush(List<Card> cards);
	boolean isStraight(List<Card> cards);
	boolean isFullHouse(List<Card> cards);
	boolean isThreeOfAKind(List<Card> cards);
	boolean isPair(List<Card> cards);
}
