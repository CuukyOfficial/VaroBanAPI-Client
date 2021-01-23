package de.varoplugin.banapi.event;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import de.varoplugin.banapi.Ban;
import de.varoplugin.banapi.UsersDataWrapper;

public class ComparisonWrapper {

	private final Map<UserBanPair<UUID>, CompareResult> minecraftResult;
	private final Map<UserBanPair<Long>, CompareResult> discordResult;

	public ComparisonWrapper(UsersDataWrapper oldData, UsersDataWrapper newData) {
		this.minecraftResult = this.compareMaps(oldData.getMinecraftBans(), newData.getMinecraftBans());
		this.discordResult = this.compareMaps(oldData.getDiscordBans(), newData.getDiscordBans());
	}

	private <T> List<UserBanPair<T>> getMissing(Map<T, Ban> searchIn, Map<T, Ban> compare) {
		List<UserBanPair<T>> missing = new ArrayList<>();
		for (T id : compare.keySet())
			if (!searchIn.containsKey(id))
				missing.add(new UserBanPair<T>(id, compare.get(id)));

		return missing;
	}

	private <T> Map<UserBanPair<T>, CompareResult> compareMaps(Map<T, Ban> oldMap, Map<T, Ban> newMap) {
		Map<UserBanPair<T>, CompareResult> comparison = new LinkedHashMap<>();
		this.getMissing(oldMap, newMap).forEach(id -> comparison.put(id, CompareResult.ADDED));
		this.getMissing(newMap, oldMap).forEach(id -> comparison.put(id, CompareResult.REMOVED));
		return comparison;
	}

	public Map<UserBanPair<UUID>, CompareResult> getMinecraftResult() {
		return minecraftResult;
	}

	public Map<UserBanPair<Long>, CompareResult> getDiscordResult() {
		return discordResult;
	}
}