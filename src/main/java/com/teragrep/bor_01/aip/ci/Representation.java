package com.teragrep.bor_01.aip.ci;

import com.teragrep.bor_01.NamespacedJsonable;

public interface Representation extends NamespacedJsonable {
    String sourceType();
    String objectFormat();
}
