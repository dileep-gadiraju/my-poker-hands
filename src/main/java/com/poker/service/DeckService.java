package com.poker.service;

import java.util.List;

import com.poker.model.Card;
import com.poker.model.DeckOfCards;

public interface DeckService {
	DeckOfCards shuffleDeck(DeckOfCards deck);
	List<Card> distribute(DeckOfCards deck, int numberOfCards);
}
