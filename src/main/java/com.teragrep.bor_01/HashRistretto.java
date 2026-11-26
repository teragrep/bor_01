package com.teragrep.bor_01;

import com.goterl.lazysodium.LazySodiumJava;
import com.goterl.lazysodium.exceptions.SodiumException;
import com.goterl.lazysodium.interfaces.Ristretto255;

public final class HashRistretto implements Ristrettoable {
    private final LazySodiumJava sodium;
    private final Hashable origin;
    public HashRistretto(final LazySodiumJava sodium, final Hashable origin) {
        this.sodium = sodium;
        this.origin = origin;
    }

    @Override
    public Ristretto255.RistrettoPoint asPoint() {
        try {
            return sodium.cryptoCoreRistretto255FromHash(origin.asHash());
        } catch (final SodiumException e) {
            throw new RuntimeException(e);
        }
    }
}
