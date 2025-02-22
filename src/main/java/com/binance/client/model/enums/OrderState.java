package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

import java.util.Set;

/**
 * SUBMITTED, PARTIALFILLED, CANCELLING. PARTIALCANCELED FILLED CANCELED CREATED
 */
public enum OrderState {
  SUBMITTED("submitted"),
  CREATED("created"),
  NEW("new"),
  PARTIALFILLED("partial-filled"),
  CANCELLING("cancelling"),
  PARTIALCANCELED("partial-canceled"),
  FILLED("filled"),
  CANCELED("canceled");


  private final String code;

  OrderState(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return code;
  }

  private static final EnumLookup<OrderState> lookup = new EnumLookup<>(OrderState.class);

  public static OrderState lookup(String name) {
    return lookup.lookup(name);
  }

  public static Set<String> aliveStates = Set.of(
          OrderState.SUBMITTED.name(),
          OrderState.CREATED.name(),
          OrderState.NEW.name(),
          OrderState.PARTIALFILLED.name()
  );
}
