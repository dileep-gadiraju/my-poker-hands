package com.cards.model;

import java.util.List;

public class RegDeckOfCards extends DeckOfCards {

	public RegDeckOfCards() {
		super();
	}

	public RegDeckOfCards(List<Card> cards) {
		super(cards);
	}

	public int getSize() {
		return cards != null ? cards.size() : 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Card c : cards) {
			sb.append(c.toString());
		}
		return sb.toString();
	}

}
