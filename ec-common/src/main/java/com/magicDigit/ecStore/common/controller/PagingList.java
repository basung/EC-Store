package com.magicDigit.ecStore.common.controller;

import java.util.List;

public interface PagingList<T> extends List<T> {
    int getTotalCount();
}
