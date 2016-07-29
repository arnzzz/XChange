package org.knowm.xchange.independentreserve.service.polling;

import java.io.IOException;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.independentreserve.IndependentReserve;
import org.knowm.xchange.independentreserve.dto.marketdata.IndependentReserveOrderBook;

import si.mazi.rescu.RestProxyFactory;

/**
 * Author: Kamil Zbikowski Date: 4/9/15
 */
public class IndependentReserveMarketDataServiceRaw extends IndependentReserveBasePollingService {
  private final IndependentReserve independentReserve;

  public IndependentReserveMarketDataServiceRaw(Exchange exchange) {
    super(exchange);
    this.independentReserve = RestProxyFactory.createProxy(IndependentReserve.class, exchange.getExchangeSpecification().getSslUri());
  }

  public IndependentReserveOrderBook getIndependentReserveOrderBook(String baseSymbol, String counterSymbol) throws IOException {
    return independentReserve.getOrderBook(baseSymbol, counterSymbol);
  }
}
