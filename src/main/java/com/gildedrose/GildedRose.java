package com.gildedrose;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		// replaced with for each loop
		for (Item item : items) {
			updateEachItem(item);
		}
	}

	private void updateEachItem(Item item) {
		// If item is not aged Brie and backstage passes to concert
		updateQualityItem(item);
		// update SellIn For Items
		updateSellInItem(item);
		// Sell In < 0 means expired items.
		if (item.sellIn < 0) {
			updateExpiredItem(item);
		}
	}

	private void updateExpiredItem(Item item) {
		if (item.name.equals("Aged Brie")) {
			increseQuality(item);
		} else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			item.quality = 0;
		} else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
		} else
			decrementQuality(item);
	}

	private void updateSellInItem(Item item) {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
			item.sellIn = item.sellIn - 1;
		}
	}

	private void updateQualityItem(Item item) {
		if (item.name.equals("Aged Brie")) {
			// Quality is not more then 50.
			increseQuality(item);
		} else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			// Quality is not more then 50.
			increseQuality(item);
			// if backstage passes quality is incresed.
			// Quality increases by 2 when there are 10 days or less
			if (item.sellIn < 11) {
				increseQuality(item);
			}
			// Quality increases by 3 when there are 5 days or less
			if (item.sellIn < 6) {
				increseQuality(item);
			}
		} else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
		} else if (item.name.equals("ConjuredItem")) {
			// For Conjured items Quality is decreased at twice.
			decrementQuality(item);
			decrementQuality(item);
		} else
			decrementQuality(item);
	}

	private void updateAgedBrieAndPassItemstoConcert(Item item) {
		// Quality is not more then 50.
		increseQuality(item);
		// if backstage passes quality is incresed.
		if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			// Quality increases by 2 when there are 10 days or less
			if (item.sellIn < 11) {
				increseQuality(item);
			}
			// Quality increases by 3 when there are 5 days or less
			if (item.sellIn < 6) {
				increseQuality(item);
			}
		}

	}

	private void increseQuality(Item item) {
		if (item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}
	
	private void decrementQuality(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}
}