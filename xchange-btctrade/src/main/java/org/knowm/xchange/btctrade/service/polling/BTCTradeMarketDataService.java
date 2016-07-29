package org.knowm.xchange.btctrade.service.polling;

import java.io.IOException;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.btctrade.BTCTradeAdapters;
import org.knowm.xchange.btctrade.dto.marketdata.BTCTradeTrade;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.service.polling.marketdata.PollingMarketDataService;

public class BTCTradeMarketDataService extends BTCTradeMarketDataServiceRaw implements PollingMarketDataService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public BTCTradeMarketDataService(Exchange exchange) {

    super(exchange);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {

    return BTCTradeAdapters.adaptTicker(getBTCTradeTicker(), currencyPair);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws IOException {

    return BTCTradeAdapters.adaptOrderBook(getBTCTradeDepth(), currencyPair);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws IOException {

    final BTCTradeTrade[] trades;
    if (args.length == 0) {
      trades = getBTCTradeTrades();
    } else {
      trades = getBTCTradeTrades(toLong(args[0]));
    }
    return BTCTradeAdapters.adaptTrades(trades, currencyPair);
  }

}
