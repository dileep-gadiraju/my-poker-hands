package com.cards.model;

import java.util.ArrayList;
import java.util.List;

public abstract class DeckOfCards {
	protected List<Card> cards;

	public DeckOfCards() {
		cards = new ArrayList<>();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cards.add(new Card(r, s));
			}
		}
	}

	public DeckOfCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> getCards() {
		return cards;
	}

}
