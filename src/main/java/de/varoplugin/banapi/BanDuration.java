package de.varoplugin.banapi;

import java.util.Arrays;
import java.util.List;

public enum BanDuration {

	MILLISECONDS("ms", "millisecond", 1L),
	SECONDS("s", "second", 1000L),
	MINUTES("min", "minute", 60L * 1000L),
	HOURS("h", "hour", 60L * 60L * 1000L),

	DAYS("d", "day", 24L * 60L * 60L * 1000L),
	WEEKS("w", "week", 7L * 24L * 60L * 60L * 1000L),
	MONTHS("m", "month", 30L * 24L * 60L * 60L * 1000L),
	YEARS("y", "year", 365L * 24L * 60L * 60L * 1000L);
	
	private final String identifier;
	private final String nameSingular;
	private final String namePlural;
	private final long millis;
	
	private BanDuration(String identifier, String name, long millis) {
		this.identifier = identifier;
		this.nameSingular = name;
		this.namePlural = name + "s";
		this.millis = millis;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getNameSingular() {
		return nameSingular;
	}
	
	public String getNamePlural() {
		return namePlural;
	}
	
	public long getMillis() {
		return millis;
	}
	
	private static final BanDuration[] sortedDurations;
	
	static {
		List<BanDuration> list = Arrays.asList(BanDuration.values());
		list.sort((BanDuration d1, BanDuration d2) -> d1.millis > d2.millis ? -1 : 1);
		sortedDurations = list.toArray(new BanDuration[0]);
	}
	
	public static String getDisplaynameFromMillis(long millis) {
		for(BanDuration duration : sortedDurations)
			if(millis % duration.millis == 0) {
				long converted = (millis / duration.millis);
				String name = converted == 1 ? duration.nameSingular : duration.namePlural;
				return String.format("%s %s", converted, name);
			}
		throw new Error();
	}
}
