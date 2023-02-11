package com.cards.service;

import java.util.List;

import com.cards.model.Card;
import com.cards.model.DeckOfCards;

public interface DeckService {
	DeckOfCards shuffleDeck(DeckOfCards deck);
	List<Card> distribute(DeckOfCards deck, int numberOfCards);
}
