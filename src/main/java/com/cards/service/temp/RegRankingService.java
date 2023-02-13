package com.cards.service.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import com.cards.model.Card;
import com.cards.model.Rank;

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
		Collections.sort(cards);
		boolean isRoyalFlush = cards.size() > 0 && cards.size() <= 5
				&& IntStream.range(0, 5).allMatch(idx -> cards.get(idx).getRank() == royalRanks.get(idx))
				&& IntStream.range(0, 4).allMatch(idx-> cards.get(idx + 1).getSuit() == cards.get(idx).getSuit());
		return isRoyalFlush;
	}

	@Override
	public boolean isStraightFlush(List<Card> cards) {
		Collections.sort(cards);
		boolean isStraightFlush = cards.size() > 0 && cards.size() <= 5 && IntStream.range(0, 4).allMatch(
				idx -> Math.abs(cards.get(idx + 1).getRank().ordinal() - cards.get(idx).getRank().ordinal()) == 1
						&& cards.get(idx + 1).getSuit() == cards.get(idx).getSuit());

		return isStraightFlush;
	}

	@Override
	public boolean isFourOfAKind(List<Card> cards) {
		Collections.sort(cards);
		boolean isFourOfKind = cards.size() == 5;
		return isFourOfKind;
	}

	@Override
	public boolean isFlush(List<Card> cards) {
		Collections.sort(cards);
		boolean isFlush = cards.size() > 0 && cards.size() <= 5
				&& IntStream.range(0, 4).allMatch(
						idx -> cards.get(idx + 1).getRank().ordinal() - cards.get(idx).getRank().ordinal() != 1
								&& cards.get(idx + 1).getSuit() == cards.get(idx).getSuit());
		return isFlush;
	}

	@Override
	public boolean isStraight(List<Card> cards) {
		Collections.sort(cards);
		boolean isStraight = cards.size() > 0 && cards.size() <= 5 && IntStream.range(0, 4).allMatch(
				idx -> Math.abs(cards.get(idx + 1).getRank().ordinal() - cards.get(idx).getRank().ordinal()) == 1
						&& cards.get(idx + 1).getSuit() != cards.get(idx).getSuit())
				&& cards.get(0).getSuit() != cards.get(4).getSuit();
		return isStraight;
	}

	@Override
	public boolean isFullHouse(List<Card> cards) {
		Collections.sort(cards);
		boolean isFullHouse = cards.size() > 0 && cards.size() <= 5
				&& IntStream.range(0, 2).allMatch(idx -> cards.get(idx + 1).getRank() == cards.get(idx).getRank())
				&& cards.get(3).getRank() == cards.get(4).getRank();
		return isFullHouse;
	}

	@Override
	public boolean isThreeOfAKind(List<Card> cards) {

		return false;
	}

	@Override
	public boolean isPair(List<Card> cards) {
		Collections.sort(cards);
		boolean pairFound = false;
		Map<Rank, List<Card>> map = new HashMap<>();
		for (Card c : cards) {
			if (map.containsKey(c.getRank())) {
				map.get(c.getRank()).add(c);
			} else {
				List<Card> list = new ArrayList<>();
				list.add(c);
				map.put(c.getRank(), list);
			}
		}
		for (Rank r : map.keySet()) {
			if (map.get(r).size() == 2) {
				pairFound=true;
				break;
			}
		}
		return cards.size() > 0 && cards.size() <= 5 && pairFound;
	}

}
