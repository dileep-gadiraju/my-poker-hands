package com.cards.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cards.model.Card;
import com.cards.model.DeckOfCards;
import com.cards.model.RegDeckOfCards;

public class RegDeckService implements DeckService {

	private static RegDeckService service;

	private RegDeckService() {

	}

	public static RegDeckService getInstance() {
		if (service == null) {
			service = new RegDeckService();
		}
		return service;
	}

	public DeckOfCards shuffleDeck(DeckOfCards deck) {
		List<Card> clone = new ArrayList<>(deck.getCards());
		Collections.shuffle(clone);
		DeckOfCards shuffledDeck = new RegDeckOfCards(clone);
		return shuffledDeck;
	}

	public List<Card> distribute(DeckOfCards deck, int numberOfCards) {
		List<Card> cards = new ArrayList<>();
		if (numberOfCards > 0 && numberOfCards <= deck.getCards().size() && deck.getCards().size() > 0) {
			cards.addAll(deck.getCards().subList(0, numberOfCards));
		}
		deck.getCards().remove(cards);
		return cards;
	}

}
