package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	@Test
	void qualityAdditionforAgedBrieItem() {
		int sellIn = 12;
		int quality = 3;
		Item item = new Item("Aged Brie", sellIn, quality);
		GildedRose gildedRose = new GildedRose(new Item[] { item });
		gildedRose.updateQuality();
		assertEquals(4, item.quality);
	}

	// No change for Surfuras Items in SellIn and Quantity
	@Test
	void isSurfurasItemNoSellInandNoDecreseinQuantity() {
		int sellIn = 12;
		int quality = 3;
		Item item = new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
		GildedRose gildedRose = new GildedRose(new Item[] { item });
		gildedRose.updateQuality();
		assertEquals(3, item.quality);
	}

	// Quality increases by 2 when there are 10 days or less
	@Test
	void qualityIncreasedBy2forBackstagepasses() {
		int sellIn = 9;
		int quality = 3;
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
		GildedRose gildedRose = new GildedRose(new Item[] { item });
		gildedRose.updateQuality();
		assertEquals(5, item.quality);
	}

	// Quality increases by 3 when there are 5 days or less
	@Test
	void qualityIncreasedBy3forBackstagepasses() {
		int sellIn = 3;
		int quality = 3;
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
		GildedRose gildedRose = new GildedRose(new Item[] { item });
		gildedRose.updateQuality();
		assertEquals(6, item.quality);
	}

	// Quality decreases for unknown items
	@Test
	void qualityDecreasedforUnknownItems() {
		int sellIn = 2;
		int quality = 2;
		Item item = new Item("QualityDecreseItem", sellIn, quality);
		GildedRose gildedRose = new GildedRose(new Item[] { item });
		gildedRose.updateQuality();
		assertEquals(1, item.quality);
	}

	// SellIn count Decreses when sold item
	@Test
	public void sellInDecreasesByDayFortItems() {
		int sellIn = 2;
		int quality = 0;
		Item sellInItem = new Item("SellInItem", sellIn, quality);
		sellInDecreasesByDayForItem(sellInItem);
	}

	private void sellInDecreasesByDayForItem(Item item) {
		GildedRose gildedRose = new GildedRose(new Item[] { item });
		gildedRose.updateQuality();
		assertEquals(1, item.sellIn);
	}

	@Test
	public void qualityDecreasesTwiceForConjuredItems() {
		int sellIn = 8;
		int quality = 4;
		Item conjuredItem = new Item("ConjuredItem", sellIn, quality);
		GildedRose gildedRose = new GildedRose(new Item[] { conjuredItem });
		gildedRose.updateQuality();
		assertEquals(2, conjuredItem.quality);
	}
}
