package com.poker.service;

import java.util.List;

import com.poker.model.Card;
import com.poker.model.PokerHand;

public interface PokerHandsService {
	PokerHand solve(List<Card> cards);
}
