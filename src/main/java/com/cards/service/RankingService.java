package com.cards.service;

import java.util.List;

import com.cards.model.Card;

public interface RankingService {
	boolean isRoyalFlush(List<Card> cards);
	boolean isStraightFlush(List<Card> cards);
}
