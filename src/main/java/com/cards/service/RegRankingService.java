package com.cards.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.cards.model.Card;
import com.cards.model.Rank;
import com.cards.model.Suit;

public class RegRankingService implements RankingService {

	private static RegRankingService service;
	private static List<Rank> royalRanks = Arrays
			.asList(new Rank[] { Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE });

	private RegRankingService() {

	}

	public static RegRankingService getInstance() {
		if (service == null) {
			service = new RegRankingService();
		}
		return service;
	}

	@Override
	public boolean isRoyalFlush(List<Card> cards) {

		boolean isRoyalFlush = cards.size() > 0 && cards.size() <= 5
				&& IntStream.range(0, 4).allMatch(idx -> cards.get(idx).getRank() == royalRanks.get(idx)
						&& cards.get(idx + 1).getSuit() == cards.get(idx).getSuit());
		return isRoyalFlush;
	}

	@Override
	public boolean isStraightFlush(List<Card> cards) {

		boolean isStraightFlush = cards.size() > 0 && cards.size() <= 5 && IntStream.range(0, 4).allMatch(
				idx -> Math.abs(cards.get(idx + 1).getRank().ordinal() - cards.get(idx).getRank().ordinal()) == 1
						&& cards.get(idx + 1).getSuit() == cards.get(idx).getSuit());

		return isStraightFlush;
	}

	@Override
	public boolean isFourOfAKind(List<Card> cards) {
		boolean isFourOfKind = cards.size() == 5;
		return isFourOfKind;
	}

	@Override
	public boolean isFlush(List<Card> cards) {
		boolean isFlush = cards.size() > 0 && cards.size() <= 5
				&& IntStream.range(0, 4).allMatch(
						idx -> cards.get(idx + 1).getRank().ordinal() - cards.get(idx).getRank().ordinal() != 1
								&& cards.get(idx + 1).getSuit() == cards.get(idx).getSuit());
		return isFlush;
	}

	@Override
	public boolean isStraight(List<Card> cards) {
		boolean isStraight = cards.size() > 0 && cards.size() <= 5 && IntStream.range(0, 4).allMatch(
				idx -> Math.abs(cards.get(idx + 1).getRank().ordinal() - cards.get(idx).getRank().ordinal()) == 1
						&& cards.get(idx + 1).getSuit() != cards.get(idx).getSuit())
				&& cards.get(0).getSuit() != cards.get(4).getSuit();
		return isStraight;
	}

}
