package com.cards.service;

import java.util.List;

import com.cards.model.Card;
import com.cards.model.PokerHand;

public interface PokerHandService {
	PokerHand solve(List<Card> cards);
}
