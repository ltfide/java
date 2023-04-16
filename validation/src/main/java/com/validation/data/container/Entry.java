package com.validation.data.container;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entry<K, V> {

    private K key;
    private V value;
}
