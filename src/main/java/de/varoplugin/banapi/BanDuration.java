package de.varoplugin.banapi;

import java.util.Arrays;
import java.util.List;

public enum BanDuration {

	MILLISECONDS("ms", "millisecond", 1L),
	SECONDS("s", "second", 1000L),
	MINUTES("min", "minute", SECONDS.millis * 60L),
	HOURS("h", "hour", MINUTES.millis * 60L),
	DAYS("d", "day", HOURS.millis * 24L),
	WEEKS("w", "week", DAYS.millis * 7L),
	MONTHS("m", "month", DAYS.millis * 30L),
	YEARS("y", "year", DAYS.millis * 365L),
	DECADES("de", "decade", YEARS.millis * 10L),
	CENTURIES("ce", "century", "centuries", YEARS.millis * 100L),
	MILLENNIA("mil", "millennium", "millenia", YEARS.millis * 1000L);

	private final String identifier;
	private final String nameSingular;
	private final String namePlural;
	private final long millis;

	private BanDuration(String identifier, String nameSingular, String namePlural, long millis) {
		this.identifier = identifier;
		this.nameSingular = nameSingular;
		this.namePlural = namePlural;
		this.millis = millis;
	}

	private BanDuration(String identifier, String name, long millis) {
		this(identifier, name, name + "s", millis);
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

	public long toUnit(long input) {
		return input / this.millis;
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

	public static long parse(String input) {
		for(BanDuration time : BanDuration.values())
			if(input.endsWith(time.getIdentifier()))
				try {
					return Long.parseLong(input.substring(0, input.length() - time.getIdentifier().length())) * time.millis;
				}catch(NumberFormatException e) {
					return -1L;
				}
		return -1L;
	}
}
