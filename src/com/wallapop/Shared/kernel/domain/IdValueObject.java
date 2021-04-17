package com.wallapop.Shared.kernel.domain;

import java.util.UUID;

public abstract class IdValueObject {
    private UUID value;

    public IdValueObject(UUID value){
        this.value = value;
    }
    public UUID getValue() { return this.value; }
}
