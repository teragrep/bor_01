package com.teragrep.bor_01;

import com.goterl.lazysodium.interfaces.Ristretto255;

public interface Ristrettoable {
    Ristretto255.RistrettoPoint asPoint();
}
