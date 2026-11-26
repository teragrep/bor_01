package com.teragrep.bor_01.aip.pdi;

import com.teragrep.bor_01.NamespacedJsonable;

import java.time.Instant;

public interface Fixity extends NamespacedJsonable {
    byte[] sha256Hash();
    Instant epochExpires();
}
