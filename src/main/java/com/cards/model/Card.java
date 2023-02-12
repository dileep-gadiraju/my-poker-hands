package com.cards.model;

import java.util.Objects;

public class Card implements Comparable<Card> {
	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

	@Override
	public int compareTo(Card o) {
		int compareValue = 0;
		if (rank.ordinal() > o.rank.ordinal()) {
			compareValue = 1;
		} else if (rank.ordinal() < o.rank.ordinal()) {
			compareValue=-1;
		}else {
			compareValue=suit.compareTo(o.suit);
		}
		return compareValue;
	}

}
