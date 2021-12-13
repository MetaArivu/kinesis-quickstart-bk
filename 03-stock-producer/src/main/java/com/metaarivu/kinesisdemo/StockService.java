package com.metaarivu.kinesisdemo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class StockService {

	private static final StockService svc = new StockService();

	private static final LinkedHashMap<String, String> stocks = new LinkedHashMap<String, String>();

	static {
		stocks.put("00000123", "3IINFOLTD|101");
		stocks.put("00000124", "INFY|1700");
		stocks.put("00000125", "TCS|3400");
		stocks.put("00000123", "HDFCBANK|1400");
		stocks.put("00000126", "ICICIBANK|750");
		stocks.put("00000127", "TATAMOTORS|500");
		stocks.put("00000128", "TECHM|1478");
		stocks.put("00000129", "WIPRO|690");
		stocks.put("000001210", "LT|1500");
		stocks.put("000001211", "RELIANCE|2300");

	}

	private StockService() {

	}

	public static StockService getInstance() {
		return svc;
	}

	public List<Stock> currentPrice() {
		List<Stock> currentStockPrice = new ArrayList<>();
		stocks.forEach((k, v) -> {
			currentStockPrice.add(this.stockPrice(k, v));
		});
		return currentStockPrice;
	}

	private Stock stockPrice(String id, String stock) {
		String str[] = stock.split("\\|");
		return new Stock(id, str[1], Double.valueOf(str[1]));
	}

}
